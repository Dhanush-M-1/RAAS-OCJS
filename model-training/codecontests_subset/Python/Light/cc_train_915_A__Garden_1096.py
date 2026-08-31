# NOME: Guilherme Lima Hernandez Rincao
# RA: 169052
# B - Garden

n, k = map(int, input().split())
b = map(int, input().split())
c = filter(float.is_integer, map(lambda a: k / a, b))
print(int(min(c)))
 		 	  	   		 	 	 	 	 	 			 	