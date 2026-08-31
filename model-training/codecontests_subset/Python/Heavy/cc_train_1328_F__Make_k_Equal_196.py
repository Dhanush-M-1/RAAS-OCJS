n, k = [int(i) for i in input().split()]
data = [int(i) for i in input().split()]

dics = []
for i in range(20):
    dics.append({})

for d in data:
    ln = len(bin(d)) - 2
    for i in range(ln, -1, -1):
        # print(bin(d))
        if d not in dics[i]:
            dics[i][d] = [ln - i]
        else:
            dics[i][d].append(ln - i)
        d >>= 1



mn = 1<<50
for i in range(20):
    dic = dics[i].values()
    for d in dic:
        if len(d) >= k:
            d.sort()
            val = sum(d[:k])
            if val < mn:
                mn = val


print(mn)

# ans2 = 0 
# vals = dics[ans].values()
# if len(vals) == 0:
#     pass
# else:
#     val = max(vals)
#     for d in dic