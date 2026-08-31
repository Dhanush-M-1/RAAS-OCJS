n = int(input())
r = ['a']
for _ in range(n - 1):
  t = []
  for s in r:
    t.append(s + chr(ord(max(s)) + 1))
    for c in set(s):
      t.append(s + c)
  r = t
print(*sorted(r), sep='\n')
