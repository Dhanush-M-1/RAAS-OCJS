q = int(input())
listValors = []

for i in range(q):
    valor = input().split(" ")
    li = int(valor[0])
    ri = int(valor[1])
    di = int(valor[2])
    if(li/di >=1 and li != di):
        print(di)
    else:
        print((int(ri/di) + 1) * di)

	 			   	  		 			  			    	 		