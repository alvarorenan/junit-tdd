package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(25000)));

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(2500)));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

    @Test
    void tentandoCriarData(){
        LocalDate data = LocalDate.of(2022, 4, 16);
        Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.of(2022, 4, 16), new BigDecimal(10000));
        assertEquals(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), funcionario.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        LocalDateTime dataeHora = LocalDateTime.of(2022, 4, 16, 13, 30);
        //verifica apenas o ano
        assertEquals(dataeHora.format(DateTimeFormatter.ofPattern("yyyy")), funcionario.getDataAdmissao().format(DateTimeFormatter.ofPattern("yyyy")));

    }


}