from collections import defaultdict

n, k = list(map(int, input().split()))

arr = []
for i in range(n):
    temp = list(map(int, input().split()))

    arr.append(temp)


d = defaultdict(list)

for i in range(len(arr)):
    ti, ai, bi = arr[i]

    if ai == 1 and bi == 1:
        if '11' in d.keys():
            d['11'].append(ti)
        else:
            d['11'] = [ti]
    elif ai == 0 and bi == 1:
        if '01' in d.keys():
            d['01'].append(ti)
        else:
            d['01'] = [ti]
    elif ai == 1 and bi == 0:
        if '10' in d.keys():
            d['10'].append(ti)
        else:
            d['10'] = [ti]


# print(d)

smallest_one = min(len(d['01']), len(d['10']))
two = len(d['11'])
for i in d.keys():
    d[i] = sorted(d[i])


# for i in d.keys():
#     sum_ = 0

#     for j in range(len(d[i])):
#         sum_ += d[i][j]

#         d[i][j] = sum_


ans = 0


l1 = 0
l2 = 0
current_k = 0
while l1 < two and l2 < smallest_one and current_k < k:

    if d['11'][l1] <= (d['01'][l2] + d['10'][l2]):
        ans += d['11'][l1]
        l1 += 1
    else:
        ans += d['01'][l2] + d['10'][l2]
        l2 += 1
    
    current_k += 1

if current_k != k and l1 < two:
    while l1 < two and current_k < k:
        ans += d['11'][l1]
        l1 += 1
        current_k += 1
elif current_k != k and l2 < smallest_one:
    while l2 < smallest_one and current_k < k:
        ans += d['01'][l2] + d['10'][l2]
        l2 += 1
        current_k += 1


if current_k == k:
    print(ans)
else:
    print(-1)
