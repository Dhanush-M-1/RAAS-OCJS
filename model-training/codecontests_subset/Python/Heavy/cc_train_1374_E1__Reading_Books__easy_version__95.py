n,k = map(int,input().split())
ab = [0]
a = [0]
b = [0]
for i in range(n):
    t,ai,bi = map(int,input().split())
    if ai == 1 and bi == 1:
        ab.append(t)
    elif ai == 1:
        a.append(t)
    elif bi == 1:
        b.append(t)
if len(ab)-1 + len(a)-1 < k or len(ab)-1 + len(b)-1 < k:
    print(-1)
else:
    ab.sort()
    a.sort()
    b.sort()
    for j in range(len(ab)-1):
        ab[j+1] = ab[j] + ab[j+1]
    for l in range(len(a)-1):
        a[l+1] = a[l] + a[l+1]
    for m in range(len(b)-1):
        b[m+1] = b[m] + b[m+1]
    ab_read = min(len(ab)-1,k)
    a_read = max(k-ab_read,0)
    b_read = max(k-ab_read,0)
    ans = ab[ab_read]+a[a_read]+b[b_read]
    for x in range(min(ab_read,len(a)-a_read-1,len(b)-b_read-1)):
        ab_read-=1
        a_read+=1
        b_read+=1
        check = ab[ab_read]+a[a_read]+b[b_read]
        if check < ans:
            ans = check
    print(ans)