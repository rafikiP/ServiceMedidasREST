package servico.medidas;

public class Avaliacao {
	private static final int ABAIXO=1;
	private static final int NORMAL=2;
	private static final int GRAU_1=3;
	private static final int GRAU_2=4;
	private static final int GRAU_3=5;
	private static final int DESNUTRICAO=6;
	private static final int ABAIXO_MEDIA=7;
	private static final int MEDIA=8;
	private static final int ACIMA_MEDIA=9;
	private static final int OBESIDADE=10;
	private static final int PERFIL_ATLETA=20;
	private static final int PERFIL_OBESO=21;
	private static final int PERFIL_DESNUTRIDO=22;
	private static final int PERFIL_GENERICO=14;
	
	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public double getIMC() {
		return IMC;
	}

	public void setIMC(double iMC) {
		IMC = iMC;
	}

	public double getGordura() {
		return gordura;
	}

	public void setGordura(double gordura) {
		this.gordura = gordura;
	}
	
	
	
		
	private int sexo;
	private double IMC,gordura;
	public Avaliacao (int sexo,double IMC,double gordura)
	{
		this.sexo=sexo;
		this.IMC=IMC;
		this.gordura=gordura;
	}
	
	private int AnaliseIMC(double IMC)
	{
		if (IMC<18.5)
		{
			return ABAIXO;
		}
		else if (IMC>=18.5 && IMC<=24.9)
		{
			return NORMAL;
		}else if (IMC>=30 && IMC <=34.9)
		{
			return GRAU_1;
		}else if (IMC>=35 && IMC <=39.9)
			return GRAU_2;
		else 
			return GRAU_3;
		
	}
	private int AnalisePercentualGordura(double Gordura)
	{
		double valorMenor, ValorMaior;
		//HOMEM
		if (sexo==1)
		{
			valorMenor=5;
			ValorMaior=25;
		}else
		{
			valorMenor=8;
			ValorMaior=32;
		}
		
		
		if (Gordura <=valorMenor )
		{
			return DESNUTRICAO;
		} else if (Gordura >=ValorMaior)
			return OBESIDADE;
		else if (gordura>16 )
			return ACIMA_MEDIA;
		else if (gordura <15)
			return ABAIXO_MEDIA;
			return MEDIA;
	}
	public int AnalisaPerfil()
	{
		 int perfil_gordura;
		 int perfil_imc;
		 perfil_imc=this.AnaliseIMC(this.IMC);
		 perfil_gordura=AnalisePercentualGordura(this.gordura);
		 if(perfil_gordura>=ACIMA_MEDIA  && perfil_imc>=GRAU_1)
		{
			return PERFIL_OBESO;
		}else if(perfil_gordura<=ABAIXO_MEDIA && perfil_imc==ABAIXO)
		 {
			 return PERFIL_DESNUTRIDO;
		 }else if (perfil_gordura<=MEDIA && perfil_imc>=NORMAL )
		 {
			 return PERFIL_ATLETA;
		 }else
			 return PERFIL_GENERICO;
		 
	}

}
