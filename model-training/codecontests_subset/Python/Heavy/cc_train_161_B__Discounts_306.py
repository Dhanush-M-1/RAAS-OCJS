I = lambda: map(int, input().split())
n, k = I()
fs = []
sc = []
Min = 1e9
for i in range(n):
    c, t = I()
    Min = min(c, Min)
    if t == 1 :
        fs += [(c, i+1)]
    else:
        sc += [(c, i+1)]

fs = sorted(fs, reverse = True)
z = [[] for i in range(k)]
sz = 0
ans = 0
for c, i in fs:
    z[sz] += [i]
    if sz < k-1:
        ans += c
        sz += 1
    else:
        ans += 2*c

for c, i in sc:
    z[sz] += [i]
    ans += 2*c
    if sz < k-1:
        sz += 1

if len(fs) >= k:
    ans -= Min

print("%.1f"%(1.0*ans/2.0))

for i in z:
    print(len(i), end = ' ')
    for j in range(len(i)):
        if j==len(i)-1:
            print(i[j])
        else:
            print(i[j], end = ' ')