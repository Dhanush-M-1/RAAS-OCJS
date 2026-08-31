n,m=map(int,input().split())
A=[i for i in range(1,m+1)]
for i in range(n):
    x=list(map(int,input().split()))
    for i in x[1:]:
        if i in A:
            A.remove(i)
if len(A)==0:
    print("YES")
else:
    print("NO")
    
