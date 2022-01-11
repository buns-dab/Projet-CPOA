package dao.client;

public interface Adresse {

	public static String normalizePays(String pays) {
		if (pays.toLowerCase().trim().equals("letzebuerg") || pays.toLowerCase().trim().equals("lux") || pays.toLowerCase().trim().equals("luxemburg")) {
			pays = "Luxembourg";

		} else if (pays.toLowerCase().trim().equals("belgium") || pays.toLowerCase().trim().equals("bel")) {
			pays = "Belgique";

		} else if (pays.toLowerCase().trim().equals("switzerland") || pays.toLowerCase().trim().equals("schweiz")) {
			pays = "Suisse";

		} else {
			String cap = pays.substring(0, 1).toUpperCase() + pays.substring(1);
			pays = cap;

		}

		return pays;
	}

	public static String normalizeVille(String ville) {
		String normalizeVille = "";
		ville = ville.toLowerCase();
		ville = ville.trim();
		ville = ville.replace("-", " ");
		String[] tabville = ville.split(" ");

		/*
		 * on stocke notre ville dans un tableau si on d�tecte une des pr�positions, on
		 * la remplace par la bonne notation ensuite on met la ville en minuscule , on
		 * met la premi�re lettre en majuscule et on concat�ne avec la ville en
		 * miniscule en retirant la premi�re lettre
		 */
		for (int i = 0; i < tabville.length; i++) {
			if ("st".equals(tabville[i])) {
				tabville[i] = "Saint";
			} else if ("ste".equals(tabville[i])) {
				tabville[i] = "Sainte";
			}
			if (!"les".contains(tabville[i]) || (!"l�s".contains(tabville[i])) || (!"le".contains(tabville[i]))
					|| (!"sous".contains(tabville[i])) || (!"sur".contains(tabville[i])) || (!"�".contains(tabville[i]))
					|| (!"aux".contains(tabville[i]))) {
				char firstChar = tabville[i].charAt(0);
				String first = String.valueOf(firstChar);
				tabville[i] = first.toUpperCase() + tabville[i].substring(1);
				normalizeVille = normalizeVille + "-" + tabville[i];
			} else {
				normalizeVille = normalizeVille + "-" + tabville[i];
			}
		}
		return normalizeVille.substring(1);

	}

	public static String normalizeVoie(String voie) {
		String voienormalize = "";
		String [] voiesep = voie.split(" ");
		for(int i =0;i<voiesep.length;i++)
		{
			if("bd".equals(voiesep[i])|| "boul".equals(voiesep[i]) || "bv".equals(voiesep[i]))
			{
				voiesep[i] = "boulevard";
			}
			else if("av".equals(voiesep[i]))
			{
				voiesep[i] = "avenue";
			}
			else if("faub".equals(voiesep[i]))
			{
				voiesep[i] = "faubourg";
			}
			else if("pl".equals(voiesep[i]))
			{
				voiesep[i] = "place";
			}
			voienormalize = voienormalize + " " + voiesep[i];
		}
		return voienormalize.substring(1);
	}

	public static String normalizeCodePst(String code_postal) {
		while(code_postal.length()<5) {
			code_postal='0'+ code_postal;
		}

				try {
					Integer codepostal =Integer.parseInt(code_postal);					
				}catch(NumberFormatException e){
					String[] parts= code_postal.split("-");		//on divise la chaine en 2 partie � partir du -
					String partie2= parts[1];					//on prend la 2�me partie (celle o� il y a les chiffres)
					code_postal=partie2;

				}
		
		return code_postal;	
	}

	public static String normalizeVirguleVoie(String voie) {
		String virg = ", ";
		voie = virg + voie;
		return voie;

	}

}
