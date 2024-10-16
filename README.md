# Conversor de Moedas em Java

## Descrição

Este é um **Conversor de Moedas** desenvolvido em **Java** que permite a conversão entre seis moedas diferentes usando taxas de câmbio dinâmicas obtidas em tempo real através da **ExchangeRate API**. A interação com o usuário é feita via console, oferecendo um menu que permite selecionar as moedas base e destino, além de inserir o valor a ser convertido.

As moedas suportadas são:
- **ARS** - Peso argentino
- **BOB** - Boliviano
- **BRL** - Real brasileiro
- **CLP** - Peso chileno
- **COP** - Peso colombiano
- **USD** - Dólar americano

## Funcionalidades
- Obtenção de taxas de câmbio em tempo real via API.
- Conversão entre seis moedas diferentes.
- Interface textual interativa via console.
- Menu dinâmico para definir moedas de base e destino, e realizar as conversões.
- Manipulação de respostas JSON usando a biblioteca Gson.

## Tecnologias Utilizadas

- **Java 17**
- **IntelliJ IDEA** (ou qualquer IDE compatível)
- **API HTTP (java.net.http.HttpClient)**
- **Biblioteca Gson** para manipulação de JSON

## Como Configurar o Projeto

### Pré-requisitos

- **Java 17** instalado.
- **IDE IntelliJ IDEA** ou outra IDE Java.
- **Chave de API** do [ExchangeRate API](https://www.exchangerate-api.com/) (necessária para acessar as taxas de câmbio).

### Passo a Passo

1. **Obtenha uma chave de API**
   - Acesse o [ExchangeRate API](https://www.exchangerate-api.com/) e crie uma conta.
   - Após se registrar, você receberá uma **chave de API**.

2. **Clone o Repositório**

   Clone o projeto para o seu ambiente local.

