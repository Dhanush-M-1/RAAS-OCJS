n,k=[int(k) for k in input().split()]
tog=[]
ali=[]
bli=[]
time=0
size=0
for i in range(n):
    t,a,b=[int(k) for k in input().split()]
    if a&b==1:
        tog.append(t)
    else:
        if a==1:
            ali.append(t)
        if b==1:
            bli.append(t)
asi=len(tog)+len(ali)
bsi=len(tog)+len(bli)
if k>min(asi,bsi):
    print(-1)
else:
    ali.sort()
    bli.sort()
    for i in range(min(len(ali),len(bli))):
        tog.append(ali[i]+bli[i])
    tog.sort()
    for i in range(k):
        time+=tog[i]
    print(time)
    
        
        
