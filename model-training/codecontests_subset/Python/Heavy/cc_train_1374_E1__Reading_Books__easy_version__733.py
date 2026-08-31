n,k=map(int,input().split())
a=[] # 1 1
b=[] #0 1
c=[] # 1 0
for i in range(n):
    t,x,y=map(int,input().split())
    if x:
        if y:
            a.append(t)
        else:
            c.append(t)
    else:
        if y:b.append(t)
if len(a)+len(b) <k or len(a)+len(c)<k:print(-1)
else:
    mn=10**10
    a=sorted(a)
    b=sorted(b)
    c=sorted(c)
    apre=[0]
    cpre=[0]
    bpre=[0]
    #print(len(a),len(b),len(c))
    for num in a:
        apre.append(apre[-1]+num)
    for num in b:
        bpre.append(bpre[-1]+num)
    for num in c:
        cpre.append(cpre[-1]+num)
    for tk in range(min(k+1,len(a)+1)):
        chane=k-tk
        #print(chane)
        if chane<=len(b) and chane<=len(c):
            sm=apre[tk]+bpre[chane]+cpre[chane]
            mn=min(sm,mn)
    print(mn)
    