n,k=map(int,input().split())
l=[]
al=[]
bl=[]
ac=bc=0
for i in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        l.append(t)
        ac+=1
        bc+=1
    elif a==1:
        al.append(t)
        ac+=1
    elif b==1:
        bl.append(t)
        bc+=1
if ac<k or bc<k:
    print('-1')
else:
    al.sort()
    bl.sort()
    i=0
    while i<len(al) and i<len(bl):
        l.append(al[i]+bl[i])
        i+=1
    l.sort()
    time=0
    for i in range(k):
        time+=l[i]
    print(time)
