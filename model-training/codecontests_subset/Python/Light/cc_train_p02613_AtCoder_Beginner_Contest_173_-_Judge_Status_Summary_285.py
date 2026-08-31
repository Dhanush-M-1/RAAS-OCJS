n = int(input())
res = [input() for _ in range(n)]
cnt = ['AC', 'WA', 'TLE', 'RE']


for c in cnt:
    print(c, 'x', res.count(c))
