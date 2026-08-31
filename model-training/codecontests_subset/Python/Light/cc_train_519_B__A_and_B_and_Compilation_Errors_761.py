#Inicio
num = int(input())
inicial = map(int, input().split())
segundo = map(int, input().split())
terceiro = map(int, input().split())

#Somas da listas
v1 = 0
v2 = 0
v3 = 0

#Somando as listas
for cont_1 in inicial:
    v1 += cont_1
for cont_2 in segundo:
    v2 += cont_2
for cont_3 in terceiro:
    v3 += cont_3
    
#Erros resolvidos
erro_1 = v1 - v2
erro_2 = v2 - v3

print(erro_1)
print(erro_2)

				 	  	 			 	 	   	  	 	 		