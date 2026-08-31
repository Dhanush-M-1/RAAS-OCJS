from collections import Counter

input()
cs = [Counter() for _ in range(3)]
for c in cs: c.update(input().split())
print(''.join((cs[0] - cs[1]).keys()))
print(''.join((cs[1] - cs[2])))