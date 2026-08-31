n = int(input())
r = 'a',
for _ in range(n - 1):
  r = [s + c for s in r for i, c in enumerate(s + chr(ord(max(s)) + 1)) if c not in s[:i]]
print(*r, sep='\n')
