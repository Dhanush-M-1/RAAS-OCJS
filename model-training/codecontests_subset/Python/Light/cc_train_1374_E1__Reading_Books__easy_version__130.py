n, k = map(int, input().split())
doubles = []
single_a = []
single_b = []
for i in range(n):
    t, a, b = map(int, input().split())
    if (a == b):
        if (a == 1):
            doubles.append(t)
    else:
        if (a):
            single_a.append([t, a, b])
        if (b):
            single_b.append([t, a, b])
single_a.sort(key = lambda x: x[0])
single_b.sort(key = lambda x: x[0])
for i in range(min(len(single_a), len(single_b))):
    ta = single_a[i][0]
    tb = single_b[i][0]
    doubles.append(ta + tb)
doubles.sort()

time = 0
if (len(doubles) < k):
    time = -1
else:
    time = sum(doubles[:k])

print (time)