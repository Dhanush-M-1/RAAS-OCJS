n,m=map(int,input().split())
inp=list(map(int,input().split()))
inp.pop(0)
z=set(inp)
for _ in range(1,n):
    inp=list(map(int,input().split()))
    inp.pop(0)
    z|=set(inp)
flag=0
for i in range(1,m+1):
    if i in z:
        pass
    else:
        print("NO")
        flag=1
        break
if(flag==0):
    print("YES")
