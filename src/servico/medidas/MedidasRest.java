package servico.medidas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/perfil")
public class MedidasRest {

	private static final int PERFIL_ATLETA = 20;
	private static final int PERFIL_OBESO = 21;
	private static final int PERFIL_DESNUTRIDO = 22;

	@GET
	@Path("/{IMC}/{GORDURA}/{SEXO}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Perfil getNoticias(@PathParam("IMC") double IMC,
			@PathParam("GORDURA") double gordura, @PathParam("SEXO") int sexo) {

		Avaliacao avaliacao = new Avaliacao(sexo, IMC, gordura);
		int perfil = avaliacao.AnalisaPerfil();
		return MontaObjetoRetorno(perfil);

	}

	private Perfil MontaObjetoRetorno(int perfil) {
		String dirArquivo;
		BufferedReader brTexto;
		BufferedReader brLink;
		StringBuilder builder = new StringBuilder();
		String linha, texto, titulo, sPerfil;
		List<Link> links = new ArrayList<Link>();
		titulo = "";

		Perfil perfilRetorno;
		switch (perfil) {
		case PERFIL_ATLETA:
			Link link = new Link(
					"Nutrição e Hipertrofia Muscular - Hipertrofia.blog",
					"http://www.hipertrofia.org/blog/2012/09/19/18-fatos-sobre-nutricao-e-hipertrofia-muscular-que-irao-amplificar-seus-resultados/");
			links.add(link);
			link = new Link(
					"Suplementação - Hipertrofia.blog",
					"http://www.hipertrofia.org/blog/2012/10/29/dica-rapida-os-3-melhores-suplementos-para-ganho-de-massa-muscular/");
			links.add(link);
			texto = "Seu perfil foi identificado como atleta. Possivelmente a relação entre o seu imc e seu % de gordura nos "
					+ "conta que você possui uma boa quantidade de massa corpérea e no entanto um percentual de gordura baixo. "
					+ "Parabéns, você é uma pessoa saudável.Seguem alguns "
					+ "referências para te ajudar a continuar com o seu ótimo perfil.";
			sPerfil = "ATLETA";
			break;
		case PERFIL_OBESO:
			link = new Link("Risco excesso de peso - Roche",
					"http://www.roche.pt/emagrecer/excessodepeso/riscos.cfm");
			links.add(link);
			link = new Link(
					"Matéria Obesidade - Veja",
					"http://veja.abril.com.br/noticia/saude/medico-esclarece-duvidas-sobre-dietas-e-obesidade");
			links.add(link);
			texto = "Seu perfil foi identificado como obeso. Possivelmente você possui uma combinação de imc e % de gordura "
					+ "alta.Diante desse resultado é recomendado a prática de exercícios acompanhado de uma dieta balanceada. "
					+ "Procure um nutricionista e um professional de ed. física para obter mais informações. Obesidade pode levar "
					+ "a sérias complicações de saúde.Seguem alguns referências para te ajudar a melhorar o seu perfil.";
			sPerfil = "OBESO";
			break;
		case PERFIL_DESNUTRIDO:
			sPerfil = "DESNUTRIDO";
			link = new Link(
					"Magreza demais prejudica saúde - Mais Equilíbrio",
					"http://maisequilibrio.terra.com.br/magreza-demais-pode-prejudicar-a-saude-5-1-4-377.html");
			links.add(link);
			link = new Link(
					"Dieta de engorda - Corpo a Corpo ",
					"http://corpoacorpo.uol.com.br/dieta/nutricao/dieta-de-engorda-ganhar-peso-com-saude/2301");
			texto = "Seu perfil foi identificado como desnutrido. Possivelmente você possui uma combunação"
					+ " de imc e % de gordura baixo. Um percentual de gordura muito baixo, bem como um imc abaixo "
					+ "do esperado são sinais de que alguma coisa está errada na sua alimentação. Tome cuidado, "
					+ "magreza demais não é sinal saúde.Seguem alguns referências para te ajudar a melhorar o seu perfil.";

			break;
		default:
			sPerfil = "GENÉRICO";
			link = new Link(
					"Benefíciod do Exercício Físico - Busque Qualidade de Vida",
					"http://www.busquequalidadedevida.com.br/?p=743");
			links.add(link);
			link = new Link("Dieta e Saúde -Viver Bem Naturalmente ",
					"http://www.viverbemnaturalmente.com/2010/10/dieta-e-saude.html");
			links.add(link);
			texto = "Seu perfil foi identificado como genérico. Possivelmente você possui uma combinação de imc e "
					+ "% de gordura dentro da média.Você é uma pessoa saudável e para continuar assim  a prática de "
					+ "exercícios e uma boa alimentação sempre vem a calhar.Seguem alguns referências para te ajudar a "
					+ "manter ou melhorar o seu perfil.";
			break;

		}
		return new Perfil(sPerfil, texto, links);
		/*
		 * try { brTexto = new BufferedReader(new
		 * FileReader("\\Perfis\\ATLETA\\texto.txt")); brLink = new
		 * BufferedReader(new FileReader("\\Perfis\\ATLETA\\links.txt"));
		 * 
		 * while ((linha = brTexto.readLine()) != null) { builder.append(linha);
		 * } texto = builder.toString(); brTexto.close();
		 * 
		 * while ((linha = brLink.readLine()) != null) { if (linha.charAt(0) ==
		 * 'T') titulo = linha; else link = linha;
		 * 
		 * if (!titulo.isEmpty() && !link.isEmpty()) { links.add(new
		 * Link(titulo.replaceFirst("T", ""), link.replaceFirst("L", ""))); } }
		 * brLink.close(); return new Perfil("ATLETA", texto, links);
		 * 
		 * } catch (FileNotFoundException e) { // TODO Auto-generated catch
		 * block System.getProperty("user.dir"); e.printStackTrace(); return
		 * null; } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); return null; }
		 */
	}
}
