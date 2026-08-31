#-----------------------------------------------------------------------
# Richard Mello
# D - k-String
#-----------------------------------------------------------------------

# Recebe
k = int(input())
s = input()

# Começa a contar
vezes = {}

for letra in s:
  if letra not in vezes: vezes[letra] = 0
  vezes[letra] += 1

# Checa impossibilidade e transforma
possivel = True
mero = ''

for letra, qtd in vezes.items():
  # Impossível
  if qtd % k != 0:
    possivel = False
    break

  # Monta
  mero += letra*(qtd//k)

# Mostra a resposta
if possivel:
  print(mero*k)
else:
  print(-1)

#-----------------------------------------------------------------------

  	 		 	 	 				   	  			 				