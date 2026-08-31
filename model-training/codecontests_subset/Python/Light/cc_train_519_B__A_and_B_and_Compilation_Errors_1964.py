entrada = int(input())
jogo1 = sorted(list(map(int,input().split())))
jogo2 = sorted(list(map(int,input().split())))
jogo3 = sorted(list(map(int,input().split())))

for i in range(len(jogo1)):
    if(i == len(jogo1)-1):
        print(jogo1[i])
        break
    if(jogo1[i] != jogo2[i]):
        print(jogo1[i])
        break

for i in range(len(jogo2)):
    if(i == len(jogo2)-1):
        print(jogo2[i])
        break
    if(jogo2[i] != jogo3[i]):
        print(jogo2[i])
        break
  
	 	 	 		    			 	     	 	 		 		