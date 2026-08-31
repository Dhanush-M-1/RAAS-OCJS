n = int(input())
s = [input() for i in range(n)]
print(*['{} x {}'.format(k, s.count(k)) for k in ['AC', 'WA', 'TLE', 'RE']], sep='\n')