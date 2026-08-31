from collections import defaultdict
n,k=list(map(int,input().split()))
d=defaultdict(list)
for i in range(n):
    t,a,b=list(map(int,input().split()))
    x=int(str(a)+str(b),2)
    d[x].append(t)
if len(d[2])+len(d[3])<k or len(d[1])+len(d[3])<k:
    print(-1)
else:
    d[1].sort()
    d[2].sort()
    d[3].sort()
    i,j,l=0,0,0
    c=0
    s=0
    while c<k:
        if l<len(d[3]):
            if i<len(d[1]):
                if(j<len(d[2])):
                    if d[1][i]+d[2][j]<d[3][l]:
                        s+=d[1][i]+d[2][j]
                        i+=1
                        j+=1
                    else:
                        s+=d[3][l]
                        l+=1
                else:
                    s+=d[3][l]
                    l+=1
            else:
                s+=d[3][l]
                l+=1
        else:
            s+=d[1][i]+d[2][j]
            i+=1
            j+=1            
        c+=1
    print(s)

