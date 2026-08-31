n, k = [int(i) for i in input().split()]
data = [int(i) for i in input().split()]

dic = [[0]*20 for j in range(200001)] 

for d in data:
    s = 0
    while d:
        dic[d][s] += 1
        d >>= 1
        s += 1
    dic[0][s] += 1

mn = 1<<30

for d in dic:
    if sum(d) >= k:
        left = k
        val = 0
        for i in range(20):
            if d[i] >= left:
                val += i * (left)
                break
            else:
                val += i * d[i]
                left -= d[i]

        if val < mn:
            mn = val
print(mn)
