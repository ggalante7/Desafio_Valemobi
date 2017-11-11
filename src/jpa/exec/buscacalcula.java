package jpa.exec;

import java.util.List;
import jpa.dao.tb_customer_accountDAO;
import jpa.model.tb_customer_account;

public class buscacalcula {
    public static void main(String[] args) {
        double soma = 0;
        int cont = 0;
        double media;
        
        tb_customer_accountDAO dao = new tb_customer_accountDAO();
        List<tb_customer_account> buscar = dao.busca();
        for (tb_customer_account c: buscar){
            soma = soma + c.getVl_total();
            cont++;
        }
        media = soma/cont;
        System.out.println("A média de saldo dos clientes selecionados é de: "+media); 
        for(tb_customer_account c: buscar){
            System.out.println(c.getId_customer() + " " + c.getNm_customer()+ " " +c.getCpf_cnpj()+ " " + c.getIs_active()+ " " + c.getVl_total());
        }
    }
}