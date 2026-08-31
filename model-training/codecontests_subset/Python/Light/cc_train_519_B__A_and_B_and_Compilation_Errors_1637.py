n = int(input())
erros = input().split()
erros2 = input().split()
erros3 = input().split()

erros = [int(x) for x in erros]
erros2 = [int(x) for x in erros2]
erros3 = [int(x) for x in erros3]

erros.sort()
erros2.sort()
erros3.sort()

s1 = 0
for i in range(len(erros2)):
    if erros[i] != erros2[i]:
        s1 = erros[i]
        break

s2 = 0
for j in range(len(erros3)):
    if erros2[j] != erros3[j]:
        s2 = erros2[j]
        break
if s1 == 0:
    s1 = erros[len(erros)-1]
if s2 == 0:
    s2 = erros2[len(erros2)-1]

print (s1)
print (s2)
   	    		 	   		 		 	  		 	 		