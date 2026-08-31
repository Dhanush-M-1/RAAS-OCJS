
# Essa Funcao tem o objetivo de encontrar a string lexicográfica minima que é 
# equivalente a string fornecida no inicio
def verify(s):
    
    # Se a string for impar retornamos, pois nao da pra dividir mais
	if len(s)%2 == 1: return s

	mid = int(len(s)/2)
	
	# Testando a primeira metade
	left = verify(s[:mid])
	
	# Testando a segunda metade
	right = verify(s[mid:])
	
	# Reordena a string
	return (left+right) if left < right else (right+left)


a = input()
b = input()

print("YES" if verify(a) == verify(b) else "NO" )

