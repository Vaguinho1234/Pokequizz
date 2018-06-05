package com.example.aluno.pokequizz;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aluno on 28/02/2018.
 */

public class AppPokequizz {

    List<Integer> pokemonRepitidos;
    private List<Pokemon> PokemonImages;

    public AppPokequizz(Context contexto){
        //testeCarregaBanco(contexto);
        PokemonImages = getListaPokemon(contexto);
        pokemonRepitidos = new ArrayList<Integer>();


    }


    // cadastro
    public String cadastrar(Context contexto, String nome, String login, String senha, String resenha){

        if (nome.length() <= 5){
            return "Nome deve ser maior que 5 caracteres.";
        }

        if (login.length() <= 5){
            return "Login deve ser maior que 5 caracteres.";
        }

        if (senha.length() <= 5){
            return "senha deve ser maior que 5 caracteres.";
        }

        if (!senha.equals(resenha)){
            return "senha incorreta, tente novamente.";
        }

        //salvar no banco
        salvarNoDB(contexto, nome, login, senha);

        return "OK";


    }

    // login
    public boolean login(Context contexto, String login, String senha){
        boolean valido = true;


        SharedPreferences sharedPref = contexto.getSharedPreferences("AppLoginExemplo", Context.MODE_PRIVATE);
        String loginDB = sharedPref.getString("login","^7j*^$89");
        String senhaDB = sharedPref.getString("senha","^7j*^$89");

        if (!login.equals(loginDB) || !senha.equals(senhaDB)) {
            valido = false;

        }
     else {

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("logado", true);
            editor.commit();


        }

        return valido;
    }

    //salvarDB
    private void salvarNoDB(Context contexto, String nome,String login,String senha) {

        SharedPreferences sharedPref = contexto.getSharedPreferences("AppLoginExemplo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nome", nome.trim());
        editor.putString("login", login.trim());
        editor.putString("senha", senha.trim());
        editor.commit();
    }

  public boolean estaLogado (Context context ){

      SharedPreferences sharedPref = context.getSharedPreferences("AppLoginExemplo", Context.MODE_PRIVATE);
       return sharedPref.getBoolean("logado",false);


  }



    public  Pokemon pokemonAelatorio(){


        Random sorte = new Random();

        boolean repitiu = false;
        int pos;

        do {

            pos = sorte.nextInt(149);

            repitiu = false;

            for (int x = 0; x < pokemonRepitidos.size(); x++) {
                if (pokemonRepitidos.get(x) == pos) {
                    repitiu = true;
                   // break;
                }
            }
        }while (repitiu && pokemonRepitidos.size() < 149);

        pokemonRepitidos.add(pos);

        return PokemonImages.get(pos);

    }

    public List<Pokemon> getListaPokemon(Context contexto)
    {
        SharedPreferences sharedPref = contexto.getSharedPreferences("data", Context.MODE_PRIVATE);
        String json = sharedPref.getString("lista","");

        Gson gson = new Gson();
        Type typeItem = new TypeToken<List<Pokemon>>(){}.getType();

        List<Pokemon> listaDoBanco = gson.fromJson(json, typeItem);

        return listaDoBanco;
    }

    public void SalvarPokemon(Context contexto,int i,float rate){
        List<Pokemon> listaDoBanco = getListaPokemon( contexto);

        listaDoBanco.get(i).rate = rate;

        Gson gson = new Gson();
        Type typeItem = new TypeToken<List<Pokemon>>(){}.getType();
        String json = gson.toJson(listaDoBanco, typeItem);

        SharedPreferences sharedPref = contexto.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("lista",json);
        editor.commit();

    }

    public void testeCarregaBanco(Context contexto)
    {
        PokemonImages = new ArrayList<Pokemon>();

      //  PokemonImages.add(new Pokemon("Abra",R.drawable.abra_,R.drawable.abra));

        PokemonImages.add(new Pokemon("abra",R.drawable.abra_,R.drawable.abra));
        PokemonImages.add(new Pokemon("aerodactyl",R.drawable.aerodactyl_,R.drawable.aerodactyl));
        PokemonImages.add(new Pokemon("alakazam",R.drawable.alakazam_,R.drawable.alakazam));
        PokemonImages.add(new Pokemon("arbok",R.drawable.arbok_,R.drawable.arbok));
        PokemonImages.add(new Pokemon("arcanine",R.drawable.arcanine_,R.drawable.arcanine));
        PokemonImages.add(new Pokemon("articuno",R.drawable.articuno_,R.drawable.articuno));
        PokemonImages.add(new Pokemon("beedrill",R.drawable.beedrill_,R.drawable.beedrill));
        PokemonImages.add(new Pokemon("bellsprout",R.drawable.bellsprout_,R.drawable.bellsprout));
        PokemonImages.add(new Pokemon("blastoise",R.drawable.blastoise_,R.drawable.blastoise));
        PokemonImages.add(new Pokemon("bulbasaur",R.drawable.bulbasaur_,R.drawable.bulbasaur));
        PokemonImages.add(new Pokemon("butterfree",R.drawable.butterfree_,R.drawable.butterfree));
        PokemonImages.add(new Pokemon("caterpie",R.drawable.caterpie_,R.drawable.caterpie));
        PokemonImages.add(new Pokemon("chansey",R.drawable.chansey_,R.drawable.chansey));
        PokemonImages.add(new Pokemon("charizard",R.drawable.charizard_,R.drawable.charizard));
        PokemonImages.add(new Pokemon("charmander",R.drawable.charmander_,R.drawable.charmander));
        PokemonImages.add(new Pokemon("charmeleon",R.drawable.charmeleon_,R.drawable.charmeleon));
        PokemonImages.add(new Pokemon("clefable",R.drawable.clefable_,R.drawable.clefable));
        PokemonImages.add(new Pokemon("clefairy",R.drawable.clefairy_,R.drawable.clefairy));
        PokemonImages.add(new Pokemon("cloyster",R.drawable.cloyster_,R.drawable.cloyster));
        PokemonImages.add(new Pokemon("cubone",R.drawable.cubone_,R.drawable.cubone));
        PokemonImages.add(new Pokemon("dewgong",R.drawable.dewgong_,R.drawable.dewgong));
        PokemonImages.add(new Pokemon("diglett",R.drawable.diglett_,R.drawable.diglett));
        PokemonImages.add(new Pokemon("ditto",R.drawable.ditto_,R.drawable.ditto));
        PokemonImages.add(new Pokemon("dodrio",R.drawable.dodrio_,R.drawable.dodrio));
        PokemonImages.add(new Pokemon("doduo",R.drawable.doduo_,R.drawable.doduo));
        PokemonImages.add(new Pokemon("dragonair",R.drawable.dragonair_,R.drawable.dragonair));
        PokemonImages.add(new Pokemon("dragonite",R.drawable.dragonite_,R.drawable.dragonite));
        PokemonImages.add(new Pokemon("dratini",R.drawable.dratini_,R.drawable.dratini));
        PokemonImages.add(new Pokemon("drowzee",R.drawable.drowzee_,R.drawable.drowzee));
        PokemonImages.add(new Pokemon("dugtrio",R.drawable.dugtrio_,R.drawable.dugtrio));
        PokemonImages.add(new Pokemon("eevee",R.drawable.eevee_,R.drawable.eevee));
        PokemonImages.add(new Pokemon("ekans",R.drawable.ekans_,R.drawable.ekans));
        PokemonImages.add(new Pokemon("electabuzz",R.drawable.electabuzz_,R.drawable.electabuzz));
        PokemonImages.add(new Pokemon("electrode",R.drawable.electrode_,R.drawable.electrode));
        PokemonImages.add(new Pokemon("exeggcute",R.drawable.exeggcute_,R.drawable.exeggcute));
        PokemonImages.add(new Pokemon("exeggutor",R.drawable.exeggutor_,R.drawable.exeggutor));
        PokemonImages.add(new Pokemon("farfetchd",R.drawable.farfetchd_,R.drawable.farfetchd));
        PokemonImages.add(new Pokemon("fearow",R.drawable.fearow_,R.drawable.fearow));
        PokemonImages.add(new Pokemon("flareon",R.drawable.flareon_,R.drawable.flareon));
        PokemonImages.add(new Pokemon("gastly",R.drawable.gastly_,R.drawable.gastly));
        PokemonImages.add(new Pokemon("gengar",R.drawable.gengar_,R.drawable.gengar));
        PokemonImages.add(new Pokemon("geodude",R.drawable.geodude_,R.drawable.geodude));
        PokemonImages.add(new Pokemon("gloom",R.drawable.gloom_,R.drawable.gloom));
        PokemonImages.add(new Pokemon("golbat",R.drawable.golbat_,R.drawable.golbat));
        PokemonImages.add(new Pokemon("goldeen",R.drawable.goldeen_,R.drawable.goldeen));
        PokemonImages.add(new Pokemon("golduck",R.drawable.golduck_,R.drawable.golduck));
        PokemonImages.add(new Pokemon("golem",R.drawable.golem_,R.drawable.golem));
        PokemonImages.add(new Pokemon("graveler",R.drawable.graveler_,R.drawable.graveler));
        PokemonImages.add(new Pokemon("grimer",R.drawable.grimer_,R.drawable.grimer));
        PokemonImages.add(new Pokemon("growlithe",R.drawable.growlithe_,R.drawable.growlithe));
        PokemonImages.add(new Pokemon("gyarados",R.drawable.gyarados_,R.drawable.gyarados));
        PokemonImages.add(new Pokemon("haunter",R.drawable.haunter_,R.drawable.haunter));
        PokemonImages.add(new Pokemon("hitmonlee",R.drawable.hitmonlee_,R.drawable.hitmonlee));
        PokemonImages.add(new Pokemon("horsea",R.drawable.horsea_,R.drawable.horsea));
        PokemonImages.add(new Pokemon("hypno",R.drawable.hypno_,R.drawable.hypno));
        PokemonImages.add(new Pokemon("ivysaur",R.drawable.ivysaur_,R.drawable.ivysaur));
        PokemonImages.add(new Pokemon("jigglypuff",R.drawable.jigglypuff_,R.drawable.jigglypuff));
        PokemonImages.add(new Pokemon("jolteon",R.drawable.jolteon_,R.drawable.jolteon));
        PokemonImages.add(new Pokemon("jynx",R.drawable.jynx_,R.drawable.jynx));
        PokemonImages.add(new Pokemon("kabuto",R.drawable.kabuto_,R.drawable.kabuto));
        PokemonImages.add(new Pokemon("kabutops",R.drawable.kabutops_,R.drawable.kabutops));
        PokemonImages.add(new Pokemon("kadabra",R.drawable.kadabra_,R.drawable.kadabra));
        PokemonImages.add(new Pokemon("kakuna",R.drawable.kakuna_,R.drawable.kakuna));
        PokemonImages.add(new Pokemon("kangaskhan",R.drawable.kangaskhan_,R.drawable.kangaskhan));
        PokemonImages.add(new Pokemon("kingler",R.drawable.kingler_,R.drawable.kingler));
        PokemonImages.add(new Pokemon("koffing",R.drawable.koffing_,R.drawable.koffing));
        PokemonImages.add(new Pokemon("krabby",R.drawable.krabby_,R.drawable.krabby));
        PokemonImages.add(new Pokemon("lapras",R.drawable.lapras_,R.drawable.lapras));
        PokemonImages.add(new Pokemon("lickitung",R.drawable.lickitung_,R.drawable.lickitung));
        PokemonImages.add(new Pokemon("machamp",R.drawable.machamp_,R.drawable.machamp));
        PokemonImages.add(new Pokemon("machoke",R.drawable.machoke_,R.drawable.machoke));
        PokemonImages.add(new Pokemon("machop",R.drawable.machop_,R.drawable.machop));
        PokemonImages.add(new Pokemon("magikarp",R.drawable.magikarp_,R.drawable.magikarp));
        PokemonImages.add(new Pokemon("magmar",R.drawable.magmar_,R.drawable.magmar));
        PokemonImages.add(new Pokemon("magnemite",R.drawable.magnemite_,R.drawable.magnemite));
        PokemonImages.add(new Pokemon("magneton",R.drawable.magneton_,R.drawable.magneton));
        PokemonImages.add(new Pokemon("mankey",R.drawable.mankey_,R.drawable.mankey));
        PokemonImages.add(new Pokemon("marowak",R.drawable.marowak_,R.drawable.marowak));
        PokemonImages.add(new Pokemon("meowth",R.drawable.meowth_,R.drawable.meowth));
        PokemonImages.add(new Pokemon("metapod",R.drawable.metapod_,R.drawable.metapod));
        PokemonImages.add(new Pokemon("mew",R.drawable.mew_,R.drawable.mew));
        PokemonImages.add(new Pokemon("mewtwo",R.drawable.mewtwo_,R.drawable.mewtwo));
        PokemonImages.add(new Pokemon("moltres",R.drawable.moltres_,R.drawable.moltres));
        PokemonImages.add(new Pokemon("mr.mime",R.drawable.mrmime_,R.drawable.mrmime));
        PokemonImages.add(new Pokemon("muk",R.drawable.muk_,R.drawable.muk));
        PokemonImages.add(new Pokemon("nidoking",R.drawable.nidoking_,R.drawable.nidoking));
        PokemonImages.add(new Pokemon("nidoqueen",R.drawable.nidoqueen_,R.drawable.nidoqueen));
        PokemonImages.add(new Pokemon("nidoran",R.drawable.nidoranfemea_,R.drawable.nidoranfemea));
        PokemonImages.add(new Pokemon("nidoran",R.drawable.nidoran_,R.drawable.nidoran));
        PokemonImages.add(new Pokemon("nidorina",R.drawable.nidorina_,R.drawable.nidorina));
        PokemonImages.add(new Pokemon("nidorino",R.drawable.nidorino_,R.drawable.nidorino));
        PokemonImages.add(new Pokemon("ninetales",R.drawable.ninetales_,R.drawable.ninetales));
        PokemonImages.add(new Pokemon("oddish",R.drawable.oddish_,R.drawable.oddish));
        PokemonImages.add(new Pokemon("omanyte",R.drawable.omanyte_,R.drawable.omanyte));
        PokemonImages.add(new Pokemon("omastar",R.drawable.omastar_,R.drawable.omastar));
        PokemonImages.add(new Pokemon("onix",R.drawable.onix_,R.drawable.onix));
        PokemonImages.add(new Pokemon("paras",R.drawable.paras_,R.drawable.paras));
        PokemonImages.add(new Pokemon("parasect",R.drawable.parasect_,R.drawable.parasect));
        PokemonImages.add(new Pokemon("persian",R.drawable.persian_,R.drawable.persian));
        PokemonImages.add(new Pokemon("pidgeot",R.drawable.pidgeot_,R.drawable.pidgeot));
        PokemonImages.add(new Pokemon("pidgeotto",R.drawable.pidgeotto_,R.drawable.pidgeotto));
        PokemonImages.add(new Pokemon("pidgey",R.drawable.pidgey_,R.drawable.pidgey));
        PokemonImages.add(new Pokemon("pikachu",R.drawable.pikachu_,R.drawable.pikachu));
        PokemonImages.add(new Pokemon("pinsir",R.drawable.pinsir_,R.drawable.pinsir));
        PokemonImages.add(new Pokemon("poliwag",R.drawable.poliwag_,R.drawable.poliwag));
        PokemonImages.add(new Pokemon("poliwhirl",R.drawable.poliwhirl_,R.drawable.poliwhirl));
        PokemonImages.add(new Pokemon("poliwrath",R.drawable.poliwrath_,R.drawable.poliwrath));
        PokemonImages.add(new Pokemon("ponyta",R.drawable.ponyta_,R.drawable.ponyta));
        PokemonImages.add(new Pokemon("porygon",R.drawable.porygon_,R.drawable.porygon));
        PokemonImages.add(new Pokemon("primeape",R.drawable.primeape_,R.drawable.primeape));
        PokemonImages.add(new Pokemon("psyduck",R.drawable.psyduck_,R.drawable.psyduck));
        PokemonImages.add(new Pokemon("raichu",R.drawable.raichu_,R.drawable.raichu));
        PokemonImages.add(new Pokemon("rapidash",R.drawable.rapidash_,R.drawable.rapidash));
        PokemonImages.add(new Pokemon("raticate",R.drawable.raticate_,R.drawable.raticate));
        PokemonImages.add(new Pokemon("rattata",R.drawable.rattata_,R.drawable.rattata));
        PokemonImages.add(new Pokemon("rhydon",R.drawable.rhydon_,R.drawable.rhydon));
        PokemonImages.add(new Pokemon("rhyhorn",R.drawable.rhyhorn_,R.drawable.rhyhorn));
        PokemonImages.add(new Pokemon("sandshrew",R.drawable.sandshrew_,R.drawable.sandshrew));
        PokemonImages.add(new Pokemon("sandslash",R.drawable.sandslash_,R.drawable.sandslash));
        PokemonImages.add(new Pokemon("scyther",R.drawable.scyther_,R.drawable.scyther));
        PokemonImages.add(new Pokemon("seadra",R.drawable.seadra_,R.drawable.seadra));
        PokemonImages.add(new Pokemon("seaking",R.drawable.seaking_,R.drawable.seaking));
        PokemonImages.add(new Pokemon("seel",R.drawable.seel_,R.drawable.seel));
        PokemonImages.add(new Pokemon("shellder",R.drawable.shellder_,R.drawable.shellder));
        PokemonImages.add(new Pokemon("slowbro",R.drawable.slowbro_,R.drawable.slowbro));
        PokemonImages.add(new Pokemon("slowpoke",R.drawable.slowpoke_,R.drawable.slowpoke));
        PokemonImages.add(new Pokemon("snorlax",R.drawable.snorlax_,R.drawable.snorlax));
        PokemonImages.add(new Pokemon("spearow",R.drawable.spearow_,R.drawable.spearow));
        PokemonImages.add(new Pokemon("squirtle",R.drawable.squirtle_,R.drawable.squirtle));
        PokemonImages.add(new Pokemon("starmie",R.drawable.starmie_,R.drawable.starmie));
        PokemonImages.add(new Pokemon("staryu",R.drawable.staryu_,R.drawable.staryu));
        PokemonImages.add(new Pokemon("tangela",R.drawable.tangela_,R.drawable.tangela));
        PokemonImages.add(new Pokemon("tauros",R.drawable.tauros_,R.drawable.tauros));
        PokemonImages.add(new Pokemon("tentacool",R.drawable.tentacool_,R.drawable.tentacool));
        PokemonImages.add(new Pokemon("tentacruel",R.drawable.tentacruel_,R.drawable.tentacruel));
        PokemonImages.add(new Pokemon("vaporeon",R.drawable.vaporeon_,R.drawable.vaporeon));
        PokemonImages.add(new Pokemon("venomoth",R.drawable.venomoth_,R.drawable.venomoth));
        PokemonImages.add(new Pokemon("venonat",R.drawable.venonat_,R.drawable.venonat));
        PokemonImages.add(new Pokemon("venusaur",R.drawable.venusaur_,R.drawable.venusaur));
        PokemonImages.add(new Pokemon("victreebell",R.drawable.victreebell_,R.drawable.victreebell));
        PokemonImages.add(new Pokemon("vileplume",R.drawable.vileplume_,R.drawable.vileplume));
        PokemonImages.add(new Pokemon("voltorb",R.drawable.voltorb_,R.drawable.voltorb));
        PokemonImages.add(new Pokemon("vulpix",R.drawable.vulpix_,R.drawable.vulpix));
        PokemonImages.add(new Pokemon("wartortle",R.drawable.wartortle_,R.drawable.wartortle));
        PokemonImages.add(new Pokemon("weedle",R.drawable.weedle_,R.drawable.weedle));
        PokemonImages.add(new Pokemon("weepinbell",R.drawable.weepinbell_,R.drawable.weepinbell));
        PokemonImages.add(new Pokemon("weezing",R.drawable.weezing_,R.drawable.weezing));
        PokemonImages.add(new Pokemon("wigglytuff",R.drawable.wigglytuff_,R.drawable.wigglytuff));
        PokemonImages.add(new Pokemon("zapdos",R.drawable.zapdos_,R.drawable.zapdos));
        PokemonImages.add(new Pokemon("zubat",R.drawable.zubat_,R.drawable.zubat));


        Gson gson = new Gson();
        Type typeItem = new TypeToken<List<Pokemon>>(){}.getType();
        String json = gson.toJson(PokemonImages, typeItem);

        SharedPreferences sharedPref = contexto.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("lista",json);
        editor.commit();




    }



}
