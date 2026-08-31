n, m = map(int, input().split())
all = []

for i in range(n):
    bulbs = list(map(int, input().split()))
    for j in bulbs[1:len(bulbs)]:
        all.append(j)

s_all = set(all)
if len(s_all) == m:
    print('YES')
else:
    print('NO')
