
n = int(input())
*v, = map(int, input().split())
c = 0
for i in range(n):
    mi = i
    for j in range(i, n):
        if v[j] < v[mi]:
            mi = j
    if mi != i:
        c += 1
    v[i], v[mi] = v[mi], v[i]


print(" ".join([str(_v) for _v in v]))
print(c)
