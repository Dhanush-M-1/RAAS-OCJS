# Nome: Guilherme Lima Hernandez Rincao
# RA: 169052
# F - A and B and Compilation Errors

n = int(input())
l1 = list(map(int, input().split()))
l2 = list(map(int, input().split()))
l3 = list(map(int, input().split()))

l1.sort()
l2.sort()
l3.sort()

for i in range(0, len(l1)):

    if i == len(l1) - 1 or l1[i] != l2[i]:
        print(l1[i])
        break

for i in range(0, len(l2)):

    if i == len(l2) - 1 or l2[i] != l3[i]:
        print(l2[i])
        break

 					   	   			 	  	 		   	 		