n = int(input())
s = [input() for _ in range(n)]

t = ('AC', 'WA', 'TLE', 'RE')
for i in t:
    print(i, 'x', s.count(i))
