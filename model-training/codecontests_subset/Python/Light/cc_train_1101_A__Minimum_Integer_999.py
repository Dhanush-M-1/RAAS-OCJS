def calculo(l,r,d):
	if(d < l):
		return(d)
	else: 
		return (((r // d) + 1 )*d)
		
entrada = int(input())

for i in range(entrada):
    valor = list(map(int,input().split()))
    
    print(calculo(valor[0],valor[1],valor[2]))
   
   

			 	 	   		 			  	 	 	   		 	