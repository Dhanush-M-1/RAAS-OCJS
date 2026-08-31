n = int(input())
line1 = list(map(int, input().split(' ')))
line2 = list(map(int, input().split(' ')))
line3 = list(map(int, input().split(' ')))

line1.sort()
line2.sort()
line3.sort()

aux = False
for i in range(n - 1):
    if line1[i] != line2[i]:
        print(line1[i])
        aux = True
        break
if not aux:
    print(line1[n - 1])

aux = False
for i in range(n - 2):
    if line2[i] != line3[i]:
        print(line2[i])
        aux = True
        break
if not aux:
    print(line2[n - 2])


	 		    	     		    			 	 		