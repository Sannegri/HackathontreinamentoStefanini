package com.stefanini.heroi.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.stefanini.heroi.dto.Duelo;
import com.stefanini.heroi.dto.Partida;
import com.stefanini.heroi.dto.PersonagemDto;
import com.stefanini.heroi.enume.Atributos;
import com.stefanini.heroi.util.BancoMemoriaUtil;

/**
 * Classe responsável pelos personagens
 * @author paulo
 *
 */

public class PersonagemBO {

	/**
	 * Carrega dados dos personagens na memória
	 * @return
	 * @throws IOException
	 */
	public List<PersonagemDto> carregaPersonagem() throws IOException{
		return BancoMemoriaUtil.getInstance().carregaPersonagens();
	}
	public PersonagemDto carregarPersonagem() throws IOException{
		List<PersonagemDto> listPersonagem = BancoMemoriaUtil.getInstance().carregaPersonagens();
		Random random = new Random();
		int numAleatorio = random.nextInt(listPersonagem.size());
		return listPersonagem.get(numAleatorio);
	}

	public Duelo createDuelo(PersonagemDto personagemVitorioso) throws IOException {
		List<PersonagemDto> listPersonagem = BancoMemoriaUtil.getInstance().carregaPersonagens();
		Random random = new Random();
		int numAleatorio = random.nextInt(listPersonagem.size());
		PersonagemDto heroi1 = (personagemVitorioso == null) ? listPersonagem.get(numAleatorio) : personagemVitorioso;
		listPersonagem.remove(numAleatorio);
		numAleatorio = random.nextInt(listPersonagem.size());
		PersonagemDto heroi2 = listPersonagem.get(numAleatorio);
		while (heroi1.getAlinhamento().equals(heroi2.getAlinhamento())) {
			numAleatorio = random.nextInt(listPersonagem.size());
			heroi2 = listPersonagem.get(numAleatorio);
		} if (!heroi1.equals(heroi2)) {
			Duelo duelo = new Duelo(Arrays.asList(heroi1, heroi2));
			boolean duelando = true;
			while (duelando) {

				int randomAtributo = random.nextInt(6) + 1;

				if (randomAtributo == Atributos.inteligencia.getCod()) {
					if (heroi1.getInteligencia() > heroi2.getInteligencia()) {
						duelo.setPersonagemVitorioso(heroi1);
						heroi1.setInteligencia(heroi1.getInteligencia()+2);
						heroi1.setVitorias(heroi1.getVitorias()+1);
						heroi2.setInteligencia(heroi2.getInteligencia()-2);
						duelo.setAtributo(Atributos.inteligencia);
						duelando=false;
					} else if (heroi1.getInteligencia() < heroi2.getInteligencia()) {
						duelo.setPersonagemVitorioso(heroi2);
						heroi2.setInteligencia(heroi2.getInteligencia()+2);
						heroi2.setVitorias(heroi2.getVitorias()+1);
						heroi1.setInteligencia(heroi1.getInteligencia()-2);
						duelo.setAtributo(Atributos.inteligencia);
						duelando=false;
					}
				} else if (randomAtributo == Atributos.forca.getCod()) {
					if (heroi1.getForca() > heroi2.getForca()) {
						duelo.setPersonagemVitorioso(heroi1);
						heroi1.setForca(heroi1.getForca()+2);
						heroi1.setVitorias(heroi1.getVitorias()+1);
						heroi2.setForca(heroi2.getForca()-2);
						duelo.setAtributo(Atributos.forca);
						duelando=false;
					} else if (heroi1.getForca() < heroi2.getForca()) {
						duelo.setPersonagemVitorioso(heroi2);
						heroi2.setForca(heroi2.getForca()+2);
						heroi2.setVitorias(heroi2.getVitorias()+1);
						heroi1.setForca(heroi1.getForca()-2);
						duelo.setAtributo(Atributos.forca);
						duelando=false;
					}
				} else if (randomAtributo == Atributos.destreza.getCod()) {
					if (heroi1.getDestreza() > heroi2.getDestreza()) {
						duelo.setPersonagemVitorioso(heroi1);
						heroi1.setDestreza(heroi1.getDestreza()+2);
						heroi1.setVitorias(heroi1.getVitorias()+1);
						heroi2.setDestreza(heroi2.getDestreza()-2);
						duelo.setAtributo(Atributos.destreza);
						duelando=false;
					} else if (heroi1.getDestreza() < heroi2.getDestreza()) {
						duelo.setPersonagemVitorioso(heroi2);
						heroi2.setDestreza(heroi2.getDestreza()+2);
						heroi2.setVitorias(heroi2.getVitorias()+1);
						heroi1.setDestreza(heroi1.getDestreza()-2);
						duelo.setAtributo(Atributos.destreza);
						duelando=false;
					}
				} else if (randomAtributo == Atributos.poder.getCod()) {
					if (heroi1.getPoder() > heroi2.getPoder()) {
						duelo.setPersonagemVitorioso(heroi1);
						heroi1.setPoder(heroi1.getPoder()+2);
						heroi1.setVitorias(heroi1.getVitorias()+1);
						heroi2.setPoder(heroi2.getPoder()-2);
						duelo.setAtributo(Atributos.poder);
						duelando=false;
					} else if (heroi1.getPoder() < heroi2.getPoder()) {
						duelo.setPersonagemVitorioso(heroi2);
						heroi2.setPoder(heroi2.getPoder()+2);
						heroi2.setVitorias(heroi2.getVitorias()+1);
						heroi1.setPoder(heroi1.getPoder()-2);
						duelo.setAtributo(Atributos.poder);
						duelando=false;
					}
				} else if (randomAtributo == Atributos.combate.getCod()) {
					if (heroi1.getCombate() > heroi2.getCombate()) {
						duelo.setPersonagemVitorioso(heroi1);
						heroi1.setCombate(heroi1.getCombate()+2);
						heroi1.setVitorias(heroi1.getVitorias()+1);
						heroi2.setCombate(heroi2.getCombate()-2);
						duelo.setAtributo(Atributos.combate);
						duelando=false;
					} else if (heroi1.getCombate() < heroi2.getCombate()) {
						duelo.setPersonagemVitorioso(heroi2);
						heroi2.setCombate(heroi2.getCombate()+2);
						heroi2.setVitorias(heroi2.getVitorias()+1);
						heroi1.setCombate(heroi1.getCombate()-2);
						duelo.setAtributo(Atributos.combate);
						duelando=false;
					}
				} else if (randomAtributo == Atributos.defesa.getCod()) {
					if (heroi1.getDefesa() > heroi2.getDefesa()) {
						duelo.setPersonagemVitorioso(heroi1);
						heroi1.setDefesa(heroi1.getDefesa()+2);
						heroi1.setVitorias(heroi1.getVitorias()+1);
						heroi2.setDefesa(heroi2.getDefesa()-2);
						duelo.setAtributo(Atributos.defesa);
						duelando=false;
					} else if (heroi1.getDefesa() < heroi2.getDefesa()) {
						duelo.setPersonagemVitorioso(heroi2);
						heroi2.setDefesa(heroi2.getDefesa()+2);
						heroi2.setVitorias(heroi2.getVitorias()+1);
						heroi1.setDefesa(heroi1.getDefesa()-2);
						duelo.setAtributo(Atributos.defesa);
						duelando=false;
					}
				}

			}
			return duelo;
		}else 
			while(heroi1.equals(heroi2)) {
				numAleatorio = random.nextInt(listPersonagem.size());
				heroi2 = listPersonagem.get(numAleatorio);
			}
		return createDuelo(heroi1);
		
	}
	public Partida createJogada(Partida partida) throws IOException {
		Duelo duelo = new Duelo(null);
		if(partida.getDuelos() == null) {
			partida = new Partida();
			duelo = createDuelo(null);
			partida.getDuelos().add(duelo);
		}else {
			if(partida.getDuelos().size()<10) {
				duelo = createDuelo(partida.getDuelos().get(partida.getDuelos().size()-1).getPersonagemVitorioso());
				partida.getDuelos().add(duelo);
			}
			if(partida.getDuelos().size()==10) {
				PersonagemDto vitorioso1 = new PersonagemDto();
				vitorioso1.setNome("z90j0asmd0m102dskd102d");
				PersonagemDto vitorioso2 = new PersonagemDto();
				vitorioso2.setNome("xc9m93m20mwks23ded");

				for(Duelo d : partida.getDuelos()) {
					for(PersonagemDto p : d.getPersonagens()) {
						if(p.getVitorias()>vitorioso1.getVitorias()) {
							if(vitorioso2.getNome().equals(p.getNome())) {
								vitorioso2=vitorioso1;
								vitorioso1=p;
							}else {
								vitorioso1=p;
							}
						}else
						if(p.getVitorias()>=vitorioso2.getVitorias() && p.getVitorias()<=vitorioso1.getVitorias() && !p.getNome().equals(vitorioso1.getNome())) {

							vitorioso2=p;
						}


					}
				}


				partida.setHeroiQueMaisVenceu(vitorioso1);
				partida.setSegundoHeroiQueMaisVenceu(vitorioso2);

			}
		}
		return partida;
	}
	public PersonagemDto createHeroiMutante(Partida partida) {
		PersonagemDto mutante = partida.getHeroiQueMaisVenceu();
		PersonagemDto heroi2 = partida.getSegundoHeroiQueMaisVenceu();
		Integer inteligencia = (mutante.getInteligencia()>heroi2.getInteligencia()) ? mutante.getInteligencia() : heroi2.getInteligencia();
		Integer forca = (mutante.getForca()>heroi2.getForca()) ? mutante.getForca() : heroi2.getForca();
		Integer destreza = (mutante.getDestreza()>heroi2.getDestreza()) ? mutante.getDestreza() : heroi2.getDestreza();
		Integer poder = (mutante.getPoder()>heroi2.getPoder()) ? mutante.getPoder() : heroi2.getPoder();
		Integer combate = (mutante.getCombate()>heroi2.getCombate()) ? mutante.getCombate() : heroi2.getCombate();
		Integer defesa = (mutante.getDefesa()>heroi2.getDefesa()) ? mutante.getDefesa() : heroi2.getDefesa();
		mutante.setNome("THE MUTANTTTT");
		mutante.setCombate(combate);
		mutante.setDefesa(defesa);
		mutante.setDestreza(destreza);
		mutante.setForca(forca);
		mutante.setInteligencia(inteligencia);
		mutante.setPoder(poder);
		return mutante;
	}

}