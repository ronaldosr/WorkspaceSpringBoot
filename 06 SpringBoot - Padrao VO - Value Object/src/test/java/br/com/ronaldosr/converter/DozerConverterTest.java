package br.com.ronaldosr.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.ronaldosr.converter.mocks.MockPessoa;
import br.com.ronaldosr.data.model.Pessoa;
import br.com.ronaldosr.data.vo.PessoaVO;

public class DozerConverterTest {

	MockPessoa inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPessoa();
    }

    @Test
    public void parseEntityToVOTest() {
        PessoaVO output = DozerConverter.parseObject(inputObject.mockEntity(), PessoaVO.class);
        Assert.assertEquals(0L, output.getId());
        Assert.assertEquals("Primeiro nome teste 0", output.getPrimeiroNome());
        Assert.assertEquals("Segundo nome teste 0", output.getSegundoNome());
        Assert.assertEquals("Endereço de teste 0", output.getEndereco());
        Assert.assertEquals("Masculino", output.getSexo());
        Assert.assertEquals("email0@.dominio.com.br", output.getEmail());
        Assert.assertEquals("278.283.578-50", output.getCpf());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PessoaVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PessoaVO.class);
        PessoaVO outputZero = outputList.get(0);
        
        Assert.assertEquals(0L, outputZero.getId());
        Assert.assertEquals("Primeiro nome teste 0", outputZero.getPrimeiroNome());
        Assert.assertEquals("Segundo nome teste 0", outputZero.getSegundoNome());
        Assert.assertEquals("Endereço de teste 0", outputZero.getEndereco());
        Assert.assertEquals("Masculino", outputZero.getSexo());
        Assert.assertEquals("email0@.dominio.com.br", outputZero.getEmail());        
        Assert.assertEquals("278.283.578-50", outputZero.getCpf());        
        
        PessoaVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(7L, outputSeven.getId());
        Assert.assertEquals("Primeiro nome teste 7", outputSeven.getPrimeiroNome());
        Assert.assertEquals("Segundo nome teste 7", outputSeven.getSegundoNome());
        Assert.assertEquals("Endereço de teste 7", outputSeven.getEndereco());
        Assert.assertEquals("Feminino", outputSeven.getSexo());
        Assert.assertEquals("email7@.dominio.com.br", outputSeven.getEmail());    
        Assert.assertEquals("278.283.578-50", outputSeven.getCpf());
        
        PessoaVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(12L, outputTwelve.getId());
        Assert.assertEquals("Primeiro nome teste 12", outputTwelve.getPrimeiroNome());
        Assert.assertEquals("Segundo nome teste 12", outputTwelve.getSegundoNome());
        Assert.assertEquals("Endereço de teste 12", outputTwelve.getEndereco());
        Assert.assertEquals("Masculino", outputTwelve.getSexo());
        Assert.assertEquals("email12@.dominio.com.br", outputTwelve.getEmail());      
        Assert.assertEquals("278.283.578-50", outputTwelve.getCpf());
    }

    @Test
    public void parseVOToEntityTest() {
        Pessoa output = DozerConverter.parseObject(inputObject.mockVO(), Pessoa.class);
        Assert.assertEquals(0L, output.getId());
        Assert.assertEquals("Primeiro nome teste 0", output.getPrimeiroNome());
        Assert.assertEquals("Segundo nome teste 0", output.getSegundoNome());
        Assert.assertEquals("Endereço de teste 0", output.getEndereco());
        Assert.assertEquals("Masculino", output.getSexo());
        Assert.assertEquals("email0@.dominio.com.br", output.getEmail());
        Assert.assertEquals("278.283.578-50", output.getCpf());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Pessoa> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Pessoa.class);
        Pessoa outputZero = outputList.get(0);
        
        Assert.assertEquals(0L, outputZero.getId());
        Assert.assertEquals("Primeiro nome teste 0", outputZero.getPrimeiroNome());
        Assert.assertEquals("Segundo nome teste 0", outputZero.getSegundoNome());
        Assert.assertEquals("Endereço de teste 0", outputZero.getEndereco());
        Assert.assertEquals("Masculino", outputZero.getSexo());
        Assert.assertEquals("email0@.dominio.com.br", outputZero.getEmail());
        Assert.assertEquals("278.283.578-50", outputZero.getCpf());
        
        Pessoa outputSeven = outputList.get(7);
        
        Assert.assertEquals(7L, outputSeven.getId());
        Assert.assertEquals("Primeiro nome teste 7", outputSeven.getPrimeiroNome());
        Assert.assertEquals("Segundo nome teste 7", outputSeven.getSegundoNome());
        Assert.assertEquals("Endereço de teste 7", outputSeven.getEndereco());
        Assert.assertEquals("Feminino", outputSeven.getSexo());
        Assert.assertEquals("email7@.dominio.com.br", outputSeven.getEmail());
        Assert.assertEquals("278.283.578-50", outputSeven.getCpf());
        
        Pessoa outputTwelve = outputList.get(12);
        
        Assert.assertEquals(12L, outputTwelve.getId());
        Assert.assertEquals("Primeiro nome teste 12", outputTwelve.getPrimeiroNome());
        Assert.assertEquals("Segundo nome teste 12", outputTwelve.getSegundoNome());
        Assert.assertEquals("Endereço de teste 12", outputTwelve.getEndereco());
        Assert.assertEquals("Masculino", outputTwelve.getSexo());
        Assert.assertEquals("email12@.dominio.com.br", outputTwelve.getEmail());
        Assert.assertEquals("278.283.578-50", outputTwelve.getCpf());
    }
}
