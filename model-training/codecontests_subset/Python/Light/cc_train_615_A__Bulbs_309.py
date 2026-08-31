args = list(map(int, input().split()))
n = args[0]
m = args[1]

bulbs = []

for i in range(n):
    for j in list(map(int, input().split()))[1:]:
        bulbs.append(j)

bulbs = list(set(bulbs))

if len(bulbs) == m:
    print('YES')
else:
    print('NO')