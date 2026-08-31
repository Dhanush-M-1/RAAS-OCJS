n,m =  map(int, input().split())
b = []
for _ in range (n):
    a = list(map(int, input().split()))
    b += a[1:]
x = list(set(b))

if len(x) == m:
    print("YES")
else:
    print("NO")
 	 	   	 		 	  					   				   	