from collections import Counter
ans = Counter(input() for _ in range(int(input())))
for i in ['AC', 'WA', 'TLE', 'RE']:
    print(f'{i} x {ans[i]}')