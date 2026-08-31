#coding: UTF-8

def verificar(l,r,d):
     x = d 
     n = int(r/d)
     
     while( (l<= x <=r) == True):
           n += 1
           x = d * n
     
     
    
     return (x)



n = int(input())

valores = []

while(n != 0):
    entrada = input()
    valores.append(entrada)
    n = n-1 
    
for i in valores:
    j = i.split(' ')
    print(verificar(int(j[0]),int(j[1]),int(j[2])))
		 	 	 	       			 						 	  		