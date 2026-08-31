def mergesort(l, r, arr, pos):
    if r - l == 1:
        return arr, pos
    m = (l + r) // 2
    arr, pos = mergesort(l, m, arr, pos)
    arr, pos = mergesort(m, r, arr, pos)
    c = [0 for i in range(r)]
    d = [0 for i in range(r)]
    poi_a = l
    poi_b = m
    for i in range(l, r):
        if poi_a == m:
            c[i] = arr[poi_b]
            d[i] = pos[poi_b]
            poi_b += 1
        elif poi_b == r:
            c[i] = arr[poi_a]
            d[i] = pos[poi_a]
            poi_a += 1
        elif a[poi_a] > arr[poi_b]:
            c[i] = arr[poi_a]
            d[i] = pos[poi_a]
            poi_a += 1
        else:
            c[i] = arr[poi_b]
            d[i] = pos[poi_b]
            poi_b += 1
    for i in range(l, r):
        arr[i] = c[i]
        pos[i] = d[i]
    return arr, pos
n = int(input())
a = list(map(int, input().split()))
p = [i for i in range(n)]
temp = a[:]
a, p = mergesort(0, n, a, p)
for m in range(int(input())):
    k, pos = map(int, input().split())
    j = k
    while j < n and a[j - 1] == a[j]:
        j += 1
    i = k - 1
    l = 1
    while i > 0 and a[i - 1] == a[i]:
        i -= 1
        l += 1
    m = sorted(p[i:j])
    res = sorted(m[:l] + p[:i])
    print(temp[res[pos - 1]])

