package com.mage.serviceImp;

import com.mage.domain.Classify;
import com.mage.domain.Document;
import com.mage.domain.DocumentAdd;
import com.mage.mapper.ClassIfyDao;
import com.mage.mapper.DocumentDao;
import com.mage.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private ClassIfyDao classIfyDao;


    @Override
    public List<Document> getAllDocuments() throws Exception {
        return documentDao.selectAllDocument();
    }

    @Override
    public void removeDocumentsById(Integer id) throws Exception {
        documentDao.deleteDocumentById(id);
    }

    @Override
    public List<Document> getDocumentsByName(String name) throws Exception {
        List<Document> allDocuments = getAllDocuments();

        List<Document> documents = new LinkedList<Document>();

        //筛选合适的结果集
        Iterator<Document> iterator = allDocuments.iterator();

        while (iterator.hasNext()) {
            Document document = iterator.next();

            //判断
            if (name.equals(document.getName())) {
                documents.add(document);
            }
        }

        return documents;
    }

    @Override
    public void addDocument(DocumentAdd documentAdd, MultipartFile file) throws Exception {

        String path = "/save"+file.getOriginalFilename();

        file.transferTo(new File(path));

        Integer integer = classIfyDao.selectClassifyByKind();

        documentAdd.setUrl(path).setUploadDate(new Date()).setUploadUserName("zhangsan").setKindNumber(integer);


        System.out.println(documentAdd);
        //调用dao存储
        // kind
        documentDao.insertDocument(documentAdd);
    }
}