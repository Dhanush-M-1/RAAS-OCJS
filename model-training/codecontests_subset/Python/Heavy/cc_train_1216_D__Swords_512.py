n = int(input())
swords = [int(i) for i in input().split()]

def mdc(a, b):
    resto = None
    while resto != 0:
        resto = a % b
        a  = b
        b  = resto
    return a

if n == 2:
    y = 1
    z = swords[1] - swords[0]
else:
    # x vai ser maior numero dado em swords
    x = max(swords)

    # calcular lista de itens roubados
    robbed = []
    for i in range(n):
        robbed.append(x - swords[i])
    
    # remover 0 dessa lista 
    for i in range(n - 1, -1, -1):
        if robbed[i] == 0:
            del robbed[i]

    # z vai ser o maior divisor comum dos numeros em robbed
    if (len(robbed)) == 1:
        y = 1
        z = robbed[0]
    else:
        z = mdc(robbed[0], robbed[1])
        i = 2
        for j in range(len(robbed) - 2):
            z = mdc(z, robbed[i])
            i += 1

        # y vai ser um somatório
        y = 0
        for i in range(n):
            y += (x - swords[i])//z

print(y, z)

				 		 	    				    	   	 			