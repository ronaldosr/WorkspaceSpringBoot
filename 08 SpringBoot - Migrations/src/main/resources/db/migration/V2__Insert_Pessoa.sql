DELETE FROM pessoa;

INSERT INTO pessoa (id, cpf, endereco, primeiro_nome, segundo_nome, sexo, email, data_nascimento)
     VALUES (1, '278.283.578-50', 'São Paulo - São Paulo - Brasil', 'Ronaldo', 'Rodrigues', 'Masculino', 'ronaldosr@gmail.com', '1980-12-22'),
            (2, '933.790.920-02', 'São Paulo - São Paulo - Brasil', 'Maria', 'Do Bairro', 'Feminino', 'mariadb@uol.com.br', '1990-05-30'),
            (3, '823.249.390-96', 'São Paulo - São Paulo - Brasil', 'Mano', 'Manolo da Silva', 'Masculino', 'manomanolo@hotmail.com', null),
            (4, '822.302.110-21', 'São Paulo - São Paulo - Brasil', 'José', 'Da Feira', 'Masculino', 'jose1999@hotmail.com', null),
            (5, '496.801.420-19', 'São Paulo - São Paulo - Brasil', 'Maria', 'Mercedes', 'Feminino', 'maria.mercedes@uol.com.br', '1986-07-05'),
            (6, '770.236.510-20', 'São Paulo - São Paulo - Brasil', 'Marimar', 'Do Mar', 'Feminino', 'marimar@uol.com.br', '2005-05-30');