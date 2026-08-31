N = int(input())
S = [input() for _ in range(N)]
V = ['AC', 'WA', 'TLE', 'RE']
for v in V:
    print('{0} x {1}'.format(v, S.count(v)))