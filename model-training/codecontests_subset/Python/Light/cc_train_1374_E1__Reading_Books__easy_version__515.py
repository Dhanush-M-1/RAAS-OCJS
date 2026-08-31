n,k = map(int,input().split())
ba = []
bb = []
bz = []
for n_ in range(n):
    t,a,b = map(int,input().split())
    if a==1 and b==1:
        bz.append(t)
    if a==1 and b==0:
        ba.append(t)
    if a==0 and b==1:
        bb.append(t)

if len(ba)+len(bz)<k or len(bb)+len(bz)<k:
    print(-1)

else:
    ba.sort()
    bb.sort()

    i=0
    while len(ba)>i and len(bb)>i:
        bz.append(ba[i]+bb[i])
        i+=1

    bz.sort()
    print(sum(bz[:k]))