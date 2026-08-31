#Problem B - Semana 4 27/03/20

nk = input()
bucketString = input()
#nk = '6 7'
#bucketString = '1 2 3 4 5 6'


nklist = nk.split(' ')
n = int(nklist[0])
k = int(nklist[1])
buckets = bucketString.split(' ')
divisiveis = []

for i in buckets:
    if (k%int(i) == 0):
        divisiveis.append(int(i))

maiorDiv = max(divisiveis)
resposta = k//maiorDiv

print(resposta)
				          		 		 	 			  				