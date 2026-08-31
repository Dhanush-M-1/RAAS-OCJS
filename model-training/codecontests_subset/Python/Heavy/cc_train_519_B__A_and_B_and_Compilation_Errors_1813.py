n = int(input())
erros1 = input().split()
erros2 = input().split()
erros3 = input().split()
printou = 0
erros1.sort()
erros2.sort()
erros3.sort()

for i in range(len(erros2)):
    if erros1[i] != erros2[i]:
        print(erros1[i])
        printou = 1
        break
if not printou:
    print(erros1[len(erros1) - 1])
else:
    printou = 0

for i in range(len(erros3)):
    if erros2[i] != erros3[i]:
        print(erros2[i])
        printou = 1
        break
if not printou:
    print(erros2[len(erros2) - 1])
 	  	  			   		  				    	 	