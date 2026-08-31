from itertools import groupby

n = int(input())
r = 'a',
for _ in range(n - 1):
  r = [s + c for s in r for c, _ in groupby(sorted(s) + [chr(ord(max(s)) + 1)])]
print(*r, sep='\n')
