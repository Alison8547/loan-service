package com.br.loanservice.service;

import com.br.loanservice.domain.Customer;
import com.br.loanservice.domain.Loan;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Log4j2
@RequiredArgsConstructor
public class PdfService {

    private final CustomerService customerService;
    private final LoanService loanService;


    public void generatedPdfLoan(Integer idLoan, HttpServletResponse httpServlet) throws IOException {
        Loan loan = loanService.findLoan(idLoan);
        Customer customer = customerService.findCustomer(loan.getIdCustomer());

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, httpServlet.getOutputStream());

        document.isOpen();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(20);

        Paragraph paragraph1 = new Paragraph("Loan Invoice", fontTitle);
        paragraph1.setAlignment(Element.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("Name: " + customer.getName(), fontParagraph);
        paragraph2.setAlignment(Element.ALIGN_LEFT);
        Paragraph paragraph3 = new Paragraph("Income: " + customer.getIncome(), fontParagraph);
        paragraph3.setAlignment(Element.ALIGN_LEFT);
        Paragraph paragraph4 = new Paragraph("Location: " + customer.getLocation(), fontParagraph);
        paragraph4.setAlignment(Element.ALIGN_LEFT);
        Paragraph paragraph5 = new Paragraph("TypeLoan: " + loan.getType(), fontParagraph);
        paragraph5.setAlignment(Element.ALIGN_LEFT);
        Paragraph paragraph6 = new Paragraph("ValueLoan: " + loan.getValueLoan(), fontParagraph);
        paragraph6.setAlignment(Element.ALIGN_LEFT);
        Paragraph paragraph7 = new Paragraph("Portion: " + loan.getPortion(), fontParagraph);
        paragraph7.setAlignment(Element.ALIGN_LEFT);
        Paragraph paragraph8 = new Paragraph("ValueInterestRateLoan: " + loan.getValueInterestRateLoan(), fontParagraph);
        paragraph8.setAlignment(Element.ALIGN_LEFT);
        Paragraph paragraph9 = new Paragraph("InstallmentPerMonth: " + loan.getInstallmentPerMonth(), fontParagraph);
        paragraph9.setAlignment(Element.ALIGN_LEFT);
        Paragraph paragraph10 = new Paragraph("InterestRate: " + loan.getInterestRate(), fontParagraph);
        paragraph10.setAlignment(Element.ALIGN_LEFT);
        Paragraph paragraph11 = new Paragraph("TimeLoan: " + loan.getTimeLoan(), fontParagraph);
        paragraph11.setAlignment(Element.ALIGN_LEFT);

        document.add(paragraph1);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.add(paragraph7);
        document.add(paragraph8);
        document.add(paragraph9);
        document.add(paragraph10);
        document.add(paragraph11);

        document.close();

        httpServlet.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String dateFormatted = dateFormat.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + dateFormatted + ".pdf";
        httpServlet.setHeader(headerKey, headerValue);
    }
}
