N=int(input())
s = [input() for i in range(N)]
for j in ('AC', 'WA', 'TLE', 'RE'):
    print(j, 'x', s.count(j))