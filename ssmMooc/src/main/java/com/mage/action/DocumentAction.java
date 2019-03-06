package com.mage.action;

import com.mage.domain.Document;
import com.mage.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mage.domain.Document;
import com.mage.service.DocumentService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class DocumentAction {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "getAllDocuments",method = RequestMethod.POST)
    @ResponseBody
    public List<Document> getAllDocumentsAction() throws Exception{
        List<Document> documents = documentService.getAllDocuments();
        System.out.println(documents);
        return documents;
    }

    @RequestMapping(value = "deleteDocumentAction")
    @ResponseBody
    public void deleteDocument(String id) throws Exception{
        int idNumber  = Integer.parseInt(id.split("-")[1]);
        documentService.removeDocumentsById(idNumber);
    }


    @RequestMapping(value = "addDocument")
    @ResponseBody
    public void addDocument(Document document,MultipartFile file) throws Exception{

    }

}
