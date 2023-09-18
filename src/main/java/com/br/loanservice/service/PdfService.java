package com.br.loanservice.service;

import com.br.loanservice.domain.Customer;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@Log4j2
@RequiredArgsConstructor
public class PdfService {

    private final CustomerService customerService;
    private final LoanService loanService;


    public void generatedPdfLoan(Integer idCustomer, Integer idLoan, HttpServletResponse httpServlet) throws IOException {
        Customer customer = customerService.findCustomer(idCustomer);
        // TODO

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, httpServlet.getOutputStream());

        document.isOpen();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("Loan Invoice", fontTitle);
        paragraph.setAlignment(Element.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("Name: ", fontParagraph);
        paragraph2.setAlignment(Element.ALIGN_LEFT);

    }
}
