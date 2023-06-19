
# devinAdotion

Este projeto consiste em uma aplicação de gerenciamento de estoque de produtos, onde o sistema é dividido em dois projetos: um front-end desenvolvido em React e um back-end desenvolvido em Spring.


# Requisitos do Projeto
## Front-end (React)
As regras de negócio devem ser centralizadas na API, não no front-end.
Utilizar a biblioteca React para o desenvolvimento do front-end.
## Back-end (Spring)
A aplicação deve ser desenvolvida em Spring, utilizando a linguagem Java.
Utilizar o banco de dados PostgreSQL para armazenar os dados.
Roteiro da Aplicação


# Requisitos da Aplicação
- Utilização do Spring Boot, Spring MVC e Spring Data.
- Criação de uma API REST para realizar as operações de gerenciamento de estoque.
- Utilização do Git com GitHub para o controle de versão do código-fonte.
- Utilização do banco de dados PostgreSQL para armazenar os dados da aplicação.

# Como Executar a Aplicação
Para executar a aplicação, siga os passos abaixo:
- Faça o clone deste repositório para obter o código-fonte.
- Certifique-se de ter o Java e o PostgreSQL instalados em sua máquina.
- Configure as informações de conexão com o banco de dados no arquivo de configuração da aplicação Spring.
- Execute o back-end da aplicação utilizando a IDE de sua preferência ou através do comando mvn spring-boot:run.
- Acesse a aplicação através do endereço http://localhost:8080.
- Logo em seguida será apresentado os endpoints para consultas na API.
## Documentação da API

## Autenticação
### Cadastrar o Usuário

```http
  POST /cadastro
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | **Obrigatório**. Nome do Usuário |
| `email` | `string` | **Obrigatório**. E-mail do Usuário |
| `password` | `string` | **Obrigatório**. Senha do Usuário |

#### Entrar/Logar com o Usuário

```http
  POST /login
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | **Obrigatório**. Nome do armazén |
| `animal` | `string` | **Obrigatório**. Tipo de animal |
| `situacao` | `boolean` | **Obrigatório**. Senha do Usuário |



### Armazén
#### Cadastrar armazém

```http
  POST /armazem
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `long` | **Obrigatório**. ID do armazém |
| `nome` | `string` | **Obrigatório**. Nome do armazém |
| `animal` | `string` | **Obrigatório**. Tipo de animal (Cachorro ou Gato) |
| `situacao` | `boolean` | **Obrigatório**. Status do armazém |

#### Listagem de todos os armazéns

```http
  GET /armazem
```

#### Listar armazém pelo o ID

```http
  GET /armazem/${id}
```

#### Desativar o armazém

```http
  PUT /armazem/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `situacao` | `boolean` | **Obrigatório**. Status do armazém |


#### Editar o armazém

```http
  PUT /armazem/${id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `long` | **Obrigatório**. ID do armazém |
| `nome` | `string` | **Obrigatório**. Nome do armazém |
| `animal` | `string` | **Obrigatório**. Tipo de animal (Cachorro ou Gato) |

#### Excluir armazém
```http
  DELETE /armazem/${id}
```

### Estoque
#### Cadastrar o estoque

```http
  POST /estoque/cadastro
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `long` | **Obrigatório**. ID do Produto |
| `produto` | `string` | **Obrigatório**. Tipo de Produto(Ração, Antipulgas ou Antiparasitario) |
| `animal` | `string` | **Obrigatório**. Tipo de animal (Cachorro ou Gato) |
| `categoria_animal` | `string` | **Obrigatório**. Categoria do animal(Filhote ou Adulto) |
| `quantidade` | `long` | **Obrigatório**. Categoria do animal(Filhote ou Adulto) |
| `armazem_id` | `long` | **Obrigatório**. ID do Armazém |


#### Listar todos os estoques

```http
  GET /estoque
```

#### Listar estoque pelo o ID

```http
  GET /estoque/${id}
```

#### Editar o armazém

```http
  PUT /estoque/${id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `produto` | `string` | **Obrigatório**. Tipo de Produto(Ração, Antipulgas ou Antiparasitario) |
| `animal` | `string` | **Obrigatório**. Tipo de animal (Cachorro ou Gato) |
| `categoria_animal` | `string` | **Obrigatório**. Categoria do animal(Filhote ou Adulto) |
| `quantidade` | `long` | **Obrigatório**. Categoria do animal(Filhote ou Adulto) |
| `armazem_id` | `long` | **Obrigatório**. ID do Armazém |

#### Excluir estoque
```http
  DELETE /estoque/${id}
```

### Dashboard
#### Carregar os registros para o dashboard

```http
  GET /estatisticas/${animal}/${categoria_animal}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `animal` | `string` | **Obrigatório**. Tipo de animal (Cachorro ou Gato) |
| `categoria_animal` | `string` | **Obrigatório**. Categoria do animal(Filhote ou Adulto) |

# Contribuição
Este projeto foi desenvolvido como parte de um trabalho em equipe. Caso queira contribuir para a melhoria desta aplicação, fique à vontade para enviar pull requests e sugestões de melhorias.


Esperamos que esta aplicação de gerenciamento de estoque de produtos seja útil e atenda aos requisitos propostos.

### Squard Back-End
- [@lenaraestudante](https://github.com/lenaraestudante)
- [@marcosouza1984](https://github.com/marcosouza1984)
- [@julianoppinheiro](https://github.com/julianoppinheiro)
- [@josejunior1995](https://github.com/josejunior1995)
- [@gabrielssi](https://github.com/gabrielssi)
- [@Josiasscheibe](https://github.com/Josiasscheibe)


### Squard Front-End
- [@Riedel-Gabriela](https://github.com/Riedel-Gabriela)
- [@Gabriela-Vasco](https://github.com/Gabriela-Vasco)
- [@gabrielssi](https://github.com/gabrielssi)
- [@marcosouza1984](https://github.com/marcosouza1984)