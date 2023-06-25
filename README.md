
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


## Documentação da API

### Autenticação
#### Cadastrar o Usuário

```http
  POST /usuario/cadastro
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | **Obrigatório**. Nome do Usuário |
| `email` | `string` | **Obrigatório**. E-mail do Usuário |
| `password` | `string` | **Obrigatório**. Senha do Usuário |

#### Entrar/Logar com o Usuário

```http
  POST /usuario/login
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `email` | `string` | **Obrigatório**. E-mail do Usuário |
| `password` | `string` | **Obrigatório**. Senha do Usuário |


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

Obs: Todos os produtos cadastro teram a situação como TRUE

#### Listagem de todos os armazéns

```http
  GET /armazem
```

#### Listar armazém pelo o ID

```http
  GET /armazem/${id}
```

#### Editar o armazém

```http
  PUT /armazem/${id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `long` | **Obrigatório**. ID do armazém |
| `nome` | `string` | **Obrigatório**. Nome do armazém |
| `animal` | `string` | **Obrigatório**. Tipo de animal (Cachorro ou Gato) |

#### Desativar o armazém

```http
  PUT /armazem/desativar/${id}
```
Obs: Se houver estoque no armazém, não será possível desativá-lo.


### Estoque
#### Cadastrar o estoque

```http
  POST /estoque
```
| Parâmetro    | Tipo     | Descrição                           |
|:-------------|:---------| :---------------------------------- |
| `id`         | `long`   | **Obrigatório**. ID do Produto |
| `produto`    | `string` | **Obrigatório**. Tipo de Produto(Ração, Antipulgas ou Antiparasitario) |
| `animal`     | `string` | **Obrigatório**. Tipo de animal (Cachorro ou Gato) |
| `categoria`  | `string` | **Obrigatório**. Categoria do animal(Filhote ou Adulto) |
| `quantidade` | `long`   | **Obrigatório**. Categoria do animal(Filhote ou Adulto) |
| `armazem`    | `any`    | **Obrigatório**. ID do Armazém |


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
| Parâmetro    | Tipo     | Descrição                           |
|:-------------|:---------| :---------------------------------- |
| `produto`    | `string` | **Obrigatório**. Tipo de Produto(Ração, Antipulgas ou Antiparasitario) |
| `quantidade` | `long`   | **Obrigatório**. Categoria do animal(Filhote ou Adulto) |

#### Excluir estoque
```http
  DELETE /estoque/${id}
```

### Dashboard
#### Carregar os registros para o dashboard

```http
  GET /estatisticas/${animal}/${categoria}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `animal` | `string` | **Obrigatório**. Tipo de animal (Cachorro ou Gato) |
| `categoria` | `string` | **Obrigatório**. Categoria do animal(Filhote ou Adulto) |

# Uso da aplicação

Espera-se que o usuário clone o projeto em seu ambiente local e configure o banco de dados [PostgreSQL](https://www.postgresql.org/) com o nome do banco de dados especificado no projeto (devinAdotion). Além disso, é necessário fornecer as credenciais do banco de dados no arquivo:
```
application.properties
```

Após configurar o ambiente, a aplicação pode ser iniciada em uma IDE, como o [IntelliJ](https://www.jetbrains.com/pt-br/idea/).

# Contribuição
Este projeto foi desenvolvido como parte de um trabalho em equipe. Caso queira contribuir para a melhoria desta aplicação, fique à vontade para enviar pull requests e sugestões de melhorias.


Esperamos que esta aplicação de gerenciamento de estoque de produtos seja útil e atenda aos requisitos propostos.

### Squard Back-End
- [@lenaraestudante](https://github.com/lenaraestudante)
- [@marcosouza1984](https://github.com/marcosouza1984)
- [@julianoppinheiro](https://github.com/julianoppinheiro)
- [@josejunior1995](https://github.com/josejunior1995)
- [@Josiasscheibe](https://github.com/Josiasscheibe)


### Squard Front-End
- [@Riedel-Gabriela](https://github.com/Riedel-Gabriela)
- [@Gabriela-Vasco](https://github.com/Gabriela-Vasco)
- [@gabrielssi](https://github.com/gabrielssi)