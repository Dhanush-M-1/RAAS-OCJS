n,k=map(int,input().split())
l1=[]
l2=[]
l3=[]
ac,bc=0,0
for i in range(n):
    t,a,b=map(int,input().split())
    if(a==1 and b==1):
        l1.append(t)
        ac+=1
        bc+=1
    elif(a==1 and b==0):
        l2.append(t)
        ac+=1
    elif(a==0 and b==1):
        l3.append(t)
        bc+=1
if(ac<k or bc<k):
    print(-1)
else:
    l2.sort()
    l3.sort()
    ans=0
    for i in range(min(len(l2),len(l3))):
        l1.append(l2[i]+l3[i])
    l1.sort()
    for i in range(k):
        ans+=l1[i]
    print(ans)
