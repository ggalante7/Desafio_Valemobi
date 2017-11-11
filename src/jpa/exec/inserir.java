package jpa.exec;

import jpa.dao.tb_customer_accountDAO;
import jpa.model.tb_customer_account;

public class inserir {
    public static void main(String[] args) {
        tb_customer_account customer = new tb_customer_account();
        customer.setCpf_cnpj("00000000000");
        customer.setIs_active(1);
        customer.setNm_customer("Usuario");
        customer.setVl_total(561.12);
        
        tb_customer_accountDAO dao = new tb_customer_accountDAO();
        customer = dao.insert(customer);
        
        System.out.println("Cliente inserido com sucesso "+ customer.getId_customer() + " " + customer.getCpf_cnpj() + " " + customer.getNm_customer() + " " + customer.getIs_active() +" "+ customer.getVl_total());
    }
}
