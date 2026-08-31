from collections import Counter
N = int(input())
C = Counter([input() for _ in range(N)])
for k in ['AC', 'WA', 'TLE', 'RE']:
    print(k, 'x', C[k])