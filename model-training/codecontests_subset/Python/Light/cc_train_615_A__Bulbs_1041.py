n,m=map(int,input().split(" "))
A=[]
for i in range(n):
    x=[int(p) for p in input().split(" ")]
    A.extend(x[1:])
if(len(set(A))==m):
    print("YES")
else:
    print("NO")        