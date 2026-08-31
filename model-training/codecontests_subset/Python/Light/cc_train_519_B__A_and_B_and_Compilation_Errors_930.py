from collections import Counter
a = input()
a = Counter(input().split(' '))
b = Counter(input().split(' '))
c = Counter(input().split(' '))
r,r2 = 0,0
for chave,valor in a.items():
  if b[chave] != valor :
    r = chave
for chave,valor in b.items():
  if c[chave] != valor :
    r2 = chave
print(r,r2)





    
     	 	  	   	 		 	 	 				 	