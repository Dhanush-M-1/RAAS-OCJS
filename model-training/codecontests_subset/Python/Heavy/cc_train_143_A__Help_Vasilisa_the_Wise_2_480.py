inp1=input().split()
inp2=input().split()
inp3=input().split()
r1=int(inp1[0])
r2=int(inp1[1])
c1=int(inp2[0])
c2=int(inp2[1])
d1=int(inp3[0])
d2=int(inp3[1])
flag=0
for i in range(1,10):
    for j in range(1,10):
        for k in range(1,10):
            for l in range(1,10):
                
                if(i+j==r1 and k+l==r2 and i+l==d1 and k+j==d2 and i+k==c1 and l+j==c2 and i!=j and i!=k and i!=l and j!=k and j!=l and k!=l):
                    a=i
                    b=j
                    c=k
                    d=l
                    flag=1
                    break
            if(flag==1):
                break
        if(flag==1):
            break
    if(flag==1):
        break
if(flag==0):
    print(-1)
else:
    print(str(a)+' '+str(b))
    print(str(c)+' '+str(d))