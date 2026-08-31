input()
d = {}
for i in range(3):
    for j in input().split():
        if j not in d:
            d[j] = [1, 0, 0]
        else:
            d[j][i] += 1
res = [0, 0]
for (k, v) in d.items():
    if v[0] != v[1]:
        res[0] = k
    if v[0] == v[1] and v[0] != v[2]:
        res[1] = k
    elif v[0] != v[1] and v[1] != v[2]:
        res[0] = res[1] = k
print("\n".join(res))
