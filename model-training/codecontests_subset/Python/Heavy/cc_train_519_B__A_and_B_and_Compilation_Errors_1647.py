n_erros = input()
primeiros_erros = input().split(' ')
segundos_erros = input().split(' ')
erros_finais = input().split(' ')
# n_erros = '5'
# primeiros_erros = ('1 5 8 123 7').split(' ')
# segundos_erros = ('123 7 5 1').split(' ')
# erros_finais = ('5 1 7').split(' ')

soma1 = 0
soma2 = 0
soma3 = 0
for i in primeiros_erros:
    soma1 += int(i)

for i in segundos_erros:
    soma2 += int(i)

for i in erros_finais:
    soma3 += int(i)

erro1 = soma1 - soma2
erro2 = soma2 - soma3
print(erro1)
print(erro2)
 	  			 			 				 		 		 	   	 		