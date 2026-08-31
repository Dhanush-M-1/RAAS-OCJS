entrada = []
entrada = input().split()

n  = int(entrada[0])
x  = int(entrada[1])
y  = int(entrada[2])

dezx = 10**x
dezy = 10**y

numero = input()
resto = list(numero[-x:])
resto.reverse()

string = list(str(dezy))

count = 1
mudancas = 0
tamanho = len(string)

for k in resto:
	#print("count = " + str(count))
	#print("tamanho = " + str(tamanho))
	#print("k = " + str(k))
	if (tamanho >= count):
		#print("string[-count] = " + string[-count])
		if(k != string[-count]):
			mudancas = mudancas + 1
	else:
		if(k != '0'):
			mudancas = mudancas + 1
	count = count + 1

print(mudancas)
