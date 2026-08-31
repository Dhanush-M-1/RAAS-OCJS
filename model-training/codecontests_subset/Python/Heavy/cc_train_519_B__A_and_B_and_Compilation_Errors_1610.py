n = int(input())
primeira = [int(x) for x in input().split()]
segunda = [int(x) for x in input().split()]
terceira = [int(x) for x in input().split()]

primeira.sort()
segunda.sort()
terceira.sort()

resp = []

segunda.append(0)
terceira.append(0)
for i in range(len(primeira)): 
    if primeira[i] != segunda[i]:
        resp.append(primeira[i])
        break

for i in range(len(segunda)): 
    if segunda[i] != terceira[i]:
        resp.append(segunda[i])
        break
for e in resp:
    print(e)


	 	 	 			   	 	  		 	 			 					