n,k=[int(x) for x in input().split()]
a,b,ab=[0],[0],[0]
for _ in range(n):
    p,q,r=[int(x) for x in input().split()]
    if q==1:
        if r==1:
            ab.append(p)
        else:
            a.append(p)
    else:
        if r==1:
            b.append(p)
if len(ab)-1+min(len(a)-1,len(b)-1)<k: print(-1); exit()
#print(a)
#print(b)
#print(ab)
a.sort()
b.sort()
ab.sort()
sumo=0
for i in range(len(a)):
    sumo+=a[i]
    a[i]=sumo
sumo=0
for i in range(len(b)):
    sumo+=b[i]
    b[i]=sumo
sumo=0
for i in range(len(ab)):
    sumo+=ab[i]
    ab[i]=sumo
#print(a)
#print(b)
#print(ab)
minans=int(1e10)
for kp in range(max(0,k+1-min(len(a),len(b))),min(len(ab),k+1)):
    minans=min(minans,a[k-kp]+b[k-kp]+ab[kp])
print(minans)
