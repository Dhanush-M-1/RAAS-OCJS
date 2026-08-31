from collections import Counter
n = int(input())
data1, data2, data3 = Counter(), Counter(), Counter()
h1 = list(map(int, input().split()))
h2 = list(map(int, input().split()))
h3 = list(map(int, input().split()))
ans1, ans2 = None, None
for i in h1:
    data1[i] += 1
for i in h2:
    data2[i] += 1
for i in h3:
    data3[i] += 1
for elem in data1:
    if data1[elem] - data2[elem] == 1:
        ans1 = elem
for elem in data2:
    if data2[elem] - data3[elem] == 1:
        ans2 = elem
print(ans1)
print(ans2)