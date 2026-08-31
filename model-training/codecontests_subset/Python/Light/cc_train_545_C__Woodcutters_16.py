t = int(input())
ht = []
pos = []
res = 1 if t < 2 else 2

for _ in range(t):
    p, h = map(int, input().split())
    ht.append(h)
    pos.append(p)

for i in range(1, t - 1):
    if (pos[i] - pos[i-1] > ht[i]):
        res += 1
    elif(pos[i + 1] - pos[i] > ht[i]):
        res += 1
        pos[i] += ht[i]

print (res)