a=int(input())
res=0
j=[]
for i in range(0,a):
    x,y,z=list(map(int,input().split()))
    if z<x or z>y:
        res=z
    else:
        res=(((y//z)+1)*z)
    j.append(res)
print(*j,sep="\n")