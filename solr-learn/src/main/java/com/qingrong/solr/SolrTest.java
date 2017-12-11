package com.qingrong.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by ZhangQingrong on 2017/7/17.
 */
public class SolrTest {

    SolrClient solrClient = null;

    @Before
    public void init(){
        solrClient = new HttpSolrClient("http://localhost:8983/solr/new_core");
    }

    @Test
    public void testAdd() throws IOException, SolrServerException {
        SolrInputDocument inputDocument = new SolrInputDocument();
        inputDocument.addField("id","002");
        inputDocument.addField("name","xiaoqin");
        inputDocument.addField("age","25");
        UpdateResponse add = solrClient.add(inputDocument);
        System.out.println(add.toString());
        solrClient.commit();
    }

    public void testQuery() throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.set("name","qingrong");
        QueryResponse query = solrClient.query(solrQuery);
    }
}
