from collections import defaultdict
n = int(input())

hash = defaultdict(list)


for i in range(n-1):
    a,b = map(int,input().split())
    hash[a].append(b)
    hash[b].append(a)
flag = 1
for i in hash.keys():
    if len(hash[i]) == 2:
        flag = 0
        break

if flag:
    print('YES')
else:
    print('NO')
