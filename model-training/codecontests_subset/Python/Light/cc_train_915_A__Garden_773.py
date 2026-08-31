# NOME: Guilherme Lima Hernandez Rincao
# RA: 169052
# B - Garden

n, k = map(int, input().split())
b = map(int, input().split())
c = list(map(lambda a: k / a, b))

min = 101

for v in c:
    if v.is_integer() and v < min:
         min = v

print(int(min))

		       		 	 		 	 	 		 	 		 	