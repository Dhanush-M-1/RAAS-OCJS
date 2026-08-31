n = int(input())
s = [input() for _ in range(n)]
for key in ('AC', 'WA', 'TLE', 'RE'):
    print('{} x {}'.format(key, s.count(key)))