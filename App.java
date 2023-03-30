import java.net.URL;
import java.io.InputStream;
import java.util.List;


public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os tops 250 TV Shows

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudosDoIMDb();

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        Conteudo conteudo = conteudos.get(0); {

            InputStream inputStream = new URL (conteudo.getUrlImagem()).openStream();
            String nomeArquivo ="saida/" + conteudo.getTitulo() + ".png";

            geradora.cria (inputStream, nomeArquivo);
                
            System.out.println(conteudo.getTitulo());
            System.out.println();
            
        }
            
            
            
        }

    }   



