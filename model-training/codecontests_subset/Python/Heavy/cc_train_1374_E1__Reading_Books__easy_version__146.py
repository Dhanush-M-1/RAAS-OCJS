n, k = input().split()
n = int(n)
k = int(k)

both = []
al = []
bl = []
for i in range(0, n):
    t, a, b = input().split()
    t = int(t)
    a = int(a)
    b = int(b)
    if a == b == 1:
        both.append(t)
    elif a == 1:
        al.append(t)
    elif b == 1:
        bl.append(t)

both.sort()
al.sort()
bl.sort()

result = []
s = 0
j = 0
while j < len(both):
    i = both[j]
    if len(al) > s and len(bl) > s and i > al[s] + bl[s]:
        result.append(al[s])
        result.append(bl[s])
        s += 1
    else:
        result.append(i)
        j += 1
    k -= 1
    if k == 0:
        break

if k > 0:
    if len(al[s:s+k]) == k and len(bl[s:s+k]) == k:
        result.extend(al[s : s + k])
        result.extend(bl[s : s + k])
        print(sum(result))
    else:
        print(-1)
else:
    print(sum(result))