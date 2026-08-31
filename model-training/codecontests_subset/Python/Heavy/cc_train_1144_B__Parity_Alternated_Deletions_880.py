n=int(input())
l1=list(map(int , input().split()))
ev1=[]
od1=[]
for i in range(n):
    if(l1[i]%2==0):
        ev1.append(l1[i])
    else:
        od1.append(l1[i])
ev=len(ev1)
od=len(od1)
if(ev==0 or od==0):
    print(sum(l1)-max(l1))
else:
    if(ev<od):
        temp=ev
    else:
        temp=od
    for j in range(temp):
        l1.remove(max(ev1))
        l1.remove(max(od1))
        ev1.remove(max(ev1))
        od1.remove(max(od1))
    if(len(l1)>0):
        l1.remove(max(l1))
    
    print(sum(l1))
    
    
    
