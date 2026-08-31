password =input()
n = int(input())
n1 = n
li = []
i = 1
check = False
while n != 0:
    temp = input()
    li.append(temp)
    n -= 1
for i in range(0,n1):
    for j in range(0,n1):
        a = li[i] + li[j]
        b = li[j] + li[i]
        if password in a or password in b:
            check = True
if check:
    print("YES")
else:
    print("NO")
        


	 		   		       	  	 	  					