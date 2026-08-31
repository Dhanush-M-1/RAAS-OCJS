# Problem K - Level Statistics

t = int(input())

while(t>0):
    t -= 1
    plays_aux = 0
    clears_aux = 0
    saida = True
    olhadas = int(input())
    for p in range (olhadas):
    
        entrada = input().split(' ')
        plays = int(entrada[0])
        clears = int(entrada[1])
        if(plays < plays_aux):
            saida = False
        if(clears < clears_aux):
            saida = False
        if((plays - plays_aux) < (clears - clears_aux)):
            saida = False
        plays_aux = plays
        clears_aux = clears

    if (saida):
        print('YES')
    else:
        print('NO')
		  		 	 	     		 	  		      		