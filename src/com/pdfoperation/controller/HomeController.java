package com.pdfoperation.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.pdfoperation.model.UserFile;

@Controller
public class HomeController {
	
	private static final String PATH_TO_MERGE = "F:\\files\\merge\\filestomerge";
	private static final String PATH_TO_SPLIT = "F:\\files\\split\\filestosplit";
	private static final String PATH_TO_PDF_TO_IMAGE = "F:\\files\\PDFConversion\\filestoconversion";
	private static final String PATH_TO_REMOVE_PAGE = "F:\\files\\removepage\\filestoremovepage";
	private static final String PATH_TO_EXTRACT_TEXT = "F:\\files\\extracttext\\filestoextracttext";
	private static final String PATH_TO_LOCK_PDF = "F:\\files\\lock\\filestolock";
	private static final String PATH_TO_UNLOCK_PDF ="F:\\files\\unlock\\filestounlock";;

	@RequestMapping(value="/")
	public String home1(HttpSession session , HttpServletRequest req) throws IOException {
		/// merge to PDF
//		File f1 = new File("E:/syllabus.pdf");
//		File f2 = new File("E:/chinese_remainder.pdf");
//		
//		PDFMergerUtility pdf = new PDFMergerUtility();
//		
//		pdf.setDestinationFileName("E:/kk.pdf");
//		pdf.addSource(f1);
//		pdf.addSource(f2);
//		pdf.mergeDocuments(null);
//		System.out.println("done");
		
		//return "Login";
		
		
		return "index";
		// amazon rest api pe dependent h spring boot
		
	}
	@RequestMapping(value="/index")
	public String home(HttpSession session , HttpServletRequest req) throws IOException {
		/// merge to PDF
//		File f1 = new File("E:/syllabus.pdf");
//		File f2 = new File("E:/chinese_remainder.pdf");
//		
//		PDFMergerUtility pdf = new PDFMergerUtility();
//		
//		pdf.setDestinationFileName("E:/kk.pdf");
//		pdf.addSource(f1);
//		pdf.addSource(f2);
//		pdf.mergeDocuments(null);
//		System.out.println("done");
		if(req.getAttribute("email").equals("neeraj@gmail.com") && req.getAttribute("password").equals("12345")) {
			session.setAttribute("id", 10);
			return "index";
		}
		else {
			return "Login";
		}
		// amazon rest api pe dependent h spring boot
		
	}
	
	@RequestMapping(value="/merge")
	public String merge() throws IOException {
		
		return "Merge";
	}
	@RequestMapping(value="/split")
	public String split() throws IOException {
		
		return "Split";
	}
	@RequestMapping(value="/extract_text")
	public String extract() throws IOException {
		
		return "ExtractText";
	}
	@RequestMapping(value="/pdf_to_image")
	public String convertToJPG() throws IOException {
		
		return "ToImage";
	}
	@RequestMapping(value="/lock")
	public String lock() throws IOException {
		return "Lock";
	}
	@RequestMapping(value="/unlock")
	public String unlock() throws IOException {
		
		return "Unlock";
	}
	
	
	@RequestMapping(value="/handle_merge" , method=RequestMethod.POST)
	public String uploadToMerge(HttpServletRequest req , UserFile userfile) throws IOException {
		
		List<String> filepaths = null;
		filepaths = uploadFileOnServer(userfile , PATH_TO_MERGE);
		merger(filepaths,req);
		System.out.println("merge done");
		return "Download";
		// amazon rest api/spring boot pe dependent h 
		
	}
	

	private List<String> uploadFileOnServer(UserFile userfile , String PATH) {
		// it upload file on server and return the path of the uploaded file
		// it takes file from UserFile class
		
		String rootdirectory = PATH;  //we can also append userid in the path
		File directory = new File(rootdirectory);
		
		if(!directory.exists()) {
			directory.mkdirs();
		}
		MultipartFile[] multipartfile  = userfile.getMultipartfile();
		
		System.out.println("No of files uploaded are : " +multipartfile.length);
		
		List<String> filepaths = new ArrayList<>();
		//loop
		
		for(MultipartFile filedata  : multipartfile) {
			
			String userfilename = filedata.getOriginalFilename();
			if(userfilename!=null && userfilename.length()>0) {
				String filepath = null ;
				try {
					filepath =  directory.getCanonicalPath()+"\\"+ userfilename ;//  */ directory.getCanonicalPath()+\"\\\"+userfilename ;
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath)); 
					bos.write(filedata.getBytes());
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				filepaths.add(filepath);
			}
			
		}
		
		return filepaths;
	}
	private void merger(List<String> filepaths , HttpServletRequest req) throws IOException {

		PDFMergerUtility pdf = new PDFMergerUtility();
		//String n  = "neeraj";
		pdf.setDestinationFileName("F:\\files\\merge\\mergedfiles\\merged.pdf");//pdf.setDestinationFileName("E:/filamerge"+n +".pdf"); // uploaded file kya kya path name du
		
		for(String s : filepaths) {
			File f = new File(s);
			pdf.addSource(f);
		}
		
		pdf.mergeDocuments(null);
		req.setAttribute("file", "F:\\files\\merge\\mergedfiles\\merged.pdf");// konsi file download kru ?
		//System.out.println("download done");
		return;
	}
	
	@RequestMapping(value="/handle_split" , method=RequestMethod.POST)
	public String uploadToSplit(HttpServletRequest req ,HttpServletResponse res , UserFile userfile) throws IOException {
		
		List<String> filepath  =  null ;
		filepath = uploadFileOnServer(userfile , PATH_TO_SPLIT);
		splitter(req ,res , filepath);
		System.out.println("split done");
		return "Download";
		// amazon rest api/spring boot pe dependent h 
		
	}
	
	public void splitter(HttpServletRequest req ,HttpServletResponse res  ,List<String> filepath ) throws IOException {
		String filename = filepath.get(0); // get the file that is going to be splitted
		File file = new File(filename);
		PDDocument pd = PDDocument.load(file);
		
		Splitter sp = new Splitter();
		List<PDDocument> lst = sp.split(pd);
		
		Iterator<PDDocument> it = lst.listIterator();
		int i=0;
		List<String> splittedFileList = new ArrayList<>();
		while(it.hasNext()) {
			
			PDDocument pd2 = it.next();
			String splittedfilepath = "F:\\files\\split\\splittedfiles\\page"+i+".pdf";
			pd2.save(splittedfilepath);
			splittedFileList.add(splittedfilepath);
			i++;
		}
		
		//req.setAttribute("listFiles", splittedFileList);// try to implement it
	
		pd.close();
		String pathToSave = "F:\\files\\split\\splittedfiles\\splittedzipped.zip";
		zipFiles(splittedFileList,req,res,pathToSave);
		return ;
		
	}
	

	@RequestMapping(value="handle_extract_text")
	public String extract(HttpServletRequest req , UserFile userfile) throws IOException {
		List<String> filepath = null;
		filepath = uploadFileOnServer(userfile , PATH_TO_EXTRACT_TEXT);
		File file = new File(filepath.get(0));
		PDDocument pd = PDDocument.load(file);
		PDFTextStripper pdf = new PDFTextStripper();
		String s = pdf.getText(pd);
		req.setAttribute("data", s);
		return "ShowExtractedText";
	}
	@RequestMapping(value="handle_remove_page")
	public String removePage(HttpServletRequest req , UserFile userfile) throws IOException {
		
		List<String> filepath = null;
		filepath = uploadFileOnServer(userfile , PATH_TO_REMOVE_PAGE);
		File file = new File(filepath.get(0));
		PDDocument pd = PDDocument.load(file);
		int totalpages = pd.getNumberOfPages();
		System.out.println("page are "+totalpages);
		pd.removePage(1);
		pd.save("F:\\files");
		pd.close();
		
		return "Download";
	}
	
	@RequestMapping(value="handle_pdf_to_image")
	public String PDFToImage(HttpServletRequest req ,HttpServletResponse res , UserFile  userfile) throws IOException {
		List<String> filepath = null;
		filepath = uploadFileOnServer(userfile , PATH_TO_PDF_TO_IMAGE);
		convertor(req,res,filepath);
		return "Download";
	}
	private void convertor(HttpServletRequest req, HttpServletResponse res, List<String> filepath) throws IOException {
		File file = new File(filepath.get(0));
		PDDocument pd = PDDocument.load(file);
		int totalpages = pd.getNumberOfPages();
		
		List<String> convertedFileList = new ArrayList<>();
		
		for(int i=0;i<totalpages;i++) {
			PDFRenderer re = new PDFRenderer(pd);
			BufferedImage image = re.renderImage(i);
			String filepathname = "F:\\files\\PDFConversion\\ConvertedImages\\image"+i+".jpeg";
			ImageIO.write(image, "JPEG", new File(filepathname));
			convertedFileList.add(filepathname);
			
		}
		pd.close();
		String pathToSave = "F:\\files\\PDFConversion\\ConvertedImages\\convertedzipped.zip";
		zipFiles(convertedFileList,req,res,pathToSave);
	}
	@RequestMapping("/handle_lock")
	public String lock(HttpServletRequest req, HttpServletResponse res, UserFile userfile) throws IOException {
		List<String> filepath = null;
		filepath = uploadFileOnServer(userfile , PATH_TO_LOCK_PDF);
		locker(req, res , filepath , req.getParameter("password"));
		return "Download";
			
	}
	
	private void locker(HttpServletRequest req, HttpServletResponse res, List<String> filepath , String password) throws IOException {
		File file = new File(filepath.get(0));
		PDDocument pd =PDDocument.load(file);
		AccessPermission ap=new AccessPermission();
		StandardProtectionPolicy policy=new StandardProtectionPolicy(password ,"neeraj!123", ap);
		policy.setEncryptionKeyLength(256);
		policy.setPermissions(ap);
		pd.protect(policy);
		pd.save("F:\\files\\lock\\lockedfiles\\locked.pdf");
		pd.close();
		req.setAttribute("file", "F:\\files\\lock\\lockedfiles\\locked.pdf");
	}

	@RequestMapping(value="handle_unlock")
	public String unlockHandler(HttpServletRequest req , UserFile  userfile) throws IOException {
		List<String> filepath = null;
		filepath = uploadFileOnServer(userfile , PATH_TO_UNLOCK_PDF);
		unlocker(req,userfile,req.getParameter("passsword"),filepath);
		return "Download";
	}
	
	private void unlocker(HttpServletRequest req, UserFile userfile, String parameter ,List<String> filepath) throws IOException {
		File file = new File(filepath.get(0));
		PDDocument pd = PDDocument.load(file,req.getParameter("password"));
		pd.setAllSecurityToBeRemoved(true);
		pd.save("F:\\files\\unlock\\unlockedfiles\\unlocked.pdf");
		pd.close();
		req.setAttribute("file", "F:\\files\\unlock\\unlockedfiles\\unlocked.pdf");
		
	}

	private void zipFiles(List<String> splittedFileList, HttpServletRequest req , HttpServletResponse res  , String pathToSave) throws IOException {
		String zipFileName = pathToSave;
		FileOutputStream fos  = new FileOutputStream(zipFileName);// to write into the file
		ZipOutputStream zos = new ZipOutputStream(fos);
		for(String filepath : splittedFileList) {
			zos.putNextEntry(new ZipEntry(new File(filepath).getName()));
			byte[] filecontentinbyte = Files.readAllBytes(Paths.get(filepath));
			zos.write(filecontentinbyte);
			zos.closeEntry();
		}
		zos.close();
		req.setAttribute("file", pathToSave);
		return ;
	}
	
	@RequestMapping(value="download", method=RequestMethod.POST)
	public String download(HttpServletRequest req ,HttpServletResponse res) throws IOException {
		String filename = req.getParameter("filepath");
		String mimeType = null;// kis file format me download krwani h file user ko 
		File f = new File(filename);
		mimeType = getMimeType(f.getCanonicalPath());
		res.setContentType(mimeType);
		res.setHeader("Content-Disposition","attachment;filename=\""+f.getName()+"\"");
		InputStream is =new FileInputStream(f);
		ServletOutputStream out=res.getOutputStream();
		IOUtils.copy(is,out);
		is.close();
		out.flush();
		out.close();
		return null;
	}

	private String getMimeType(String canonicalPath) {
		canonicalPath = canonicalPath.toLowerCase();
		if(canonicalPath.endsWith(".jpg") || canonicalPath.endsWith(".jpeg") || canonicalPath.endsWith(".jpe")) {
			return "image/jpg";
		}
		else if(canonicalPath.endsWith(".pdf")) {
			return "application/pdf";
		}
		else if(canonicalPath.endsWith(".pdf")) {
			return "image/png";
		}
		else if(canonicalPath.endsWith(".zip")) {
			return "application/zip";
		}
		else 
			return "application/pdf";
		
	}
	@RequestMapping("sendemail")
	public String email() throws AddressException, MessagingException {
		
		Properties p= new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.EnableSSL.enable", "true");
		p.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.socketFactory.port", "465");
		
		Session session=Session.getInstance(p, new SimpleAuthenticator("neerajgmsaini@gmail.com","######"));
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("neerajgmsaini@gmail.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("tomail@gmail.com"));
		msg.setSubject("email sending application");
		msg.setContent("first automatic email", "text/html");	
		Transport.send(msg);
		return  "index";
	}
	
	
}
