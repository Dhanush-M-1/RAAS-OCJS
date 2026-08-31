from collections import defaultdict

s = input()
n, m = list(map(int, s.split()))

a = list(map(lambda x: int(x) % m, input().split()))
b = list(map(lambda x: int(x) % m, input().split()))

d1 = defaultdict(int)
d2 = defaultdict(int)

for x in a:
    d1[x] += 1
for x in b:
    d2[x] += 1

x1 = sorted(d1.items(), key=lambda x: (x[1], x[0]))
x2 = sorted(d2.items(), key=lambda x: (x[1], x[0]))

for i in range(len(x2)):
    d = (x2[i][0] - x1[0][0]) % m
    flag = True
    for j in range(len(x1)):
        if x1[j][1] != d2[(x1[j][0] + d) % m]:
            flag = False
            break
    if flag:
        print(d)
        break
