def mi():
    return map(int, input().split())
n,k=mi()
a,b,ab=[],[],[]
for i in range(n):
    t,al,bl=mi()
    lab,la,lb = 0,0,0
    if al and bl:
        ab.append(t)
    elif al:
        a.append(t)
    elif bl:
        b.append(t)
b.sort(), a.sort(), ab.sort()
la,lb,lab=len(a),len(b),len(ab)
for i in range(1, lb):
    b[i]+=b[i-1]
for i in range(1, la):
    a[i]+=a[i-1]
ans = 1e10
if len(a)>=k and len(b)>=k:
    ans=a[k-1]+b[k-1]
for i in range(lab):
    # print(ab, i, a, k)
    if i > 0:
        ab[i] += ab[i-1]
    if not k-1-i:
        ans = min(ans, ab[i])
    if k-1-i>0 and min(len(a),len(b))>=k-1-i:
        ans = min(ans, ab[i]+a[k-i-2]+b[k-i-2])
if ans==1e10:
    ans=-1
print(ans)
    
