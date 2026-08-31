n, m = input().split()
n = int(n)
m = int(m)

flag = [False]*m

for i in range(n):
    a = list(map(int, input().split()))

    for j in range(1, len(a)):
        flag[a[j]-1] = True

f = False
for i in range(m):
    if(flag[i] == False):
        print("NO")
        f = True
        break

if(f == False):
    print("YES")
		 	    	 		 	 	   		 	 		 		