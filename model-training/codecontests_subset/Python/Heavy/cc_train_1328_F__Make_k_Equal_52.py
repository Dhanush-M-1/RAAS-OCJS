n, k = [int(i) for i in input().split()]
data = [int(i) for i in input().split()]

dic = [[0]*20 for j in range(200001)] 
# for i in range(20):
#     dics.append(     )

for d in data:
    # ln = len(bin(d)) - 2
    s = 0
    while d:
        dic[d][s] += 1
        d >>= 1
        s += 1
    dic[0][s] += 1

mn = 1<<30
# for i in range(20):
#     dic = dics[i].values()
for d in dic:
    if sum(d) >= k:
        left = k
        val = 0
        # for _ in range(int(input())):
#     n = int(input())
#     data = [int(i) for i in input().split()]
#     mx = [0] * n
#     mx1 = 1 <<50
#     for i in range(n-1, -1, -1):
#         mx[i] = mx1
#         mx1 = min(data[i], mx1)
#     ans = 0
#     for i in range(n):
#         if data[i] > mx[i]:
#             ans += 1
#     print(ans)

        for i in range(20):
            if d[i] >= left:
                val += i * (left)
                break
            else:
                val += i * d[i]
                left -= d[i]

        # val = sum(d[:k])
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