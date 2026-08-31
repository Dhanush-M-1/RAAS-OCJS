def conta_pedras (ent):
    if ent[1] == 0:
        return 0
    else:
        cont = 0
        if ent[2] == 0 or ent[2] == 1:
            if ent[1]//2 > ent[0]:
                return 3 * ent[0]
            else:
                return 3 * (ent[1]//2)
        else:
            if ent[2]//2 > ent[1]:
                return 3 * ent[1]
            else:
                cont += 3 * (ent[2]//2)
                ent[1] -= ent[2]//2
                ent[2] -= 2 * (ent[2]//2)
                if ent[1]//2 > ent[0]:
                    cont += 3 * ent[0]
                else:
                    cont += 3 * (ent[1]//2)
            return cont


    
n = int(input())

for i  in range (0, n):
    ent = list(map(int,input().strip().split()))[:3]
    print(conta_pedras(ent))
    		 	   			 	   			 		  	  	