n, *s = open(0).read().split()

from collections import Counter

c = Counter(s)

for ch in ['AC', 'WA', 'TLE', 'RE']:
    print(f'{ch} x {c[ch]}')