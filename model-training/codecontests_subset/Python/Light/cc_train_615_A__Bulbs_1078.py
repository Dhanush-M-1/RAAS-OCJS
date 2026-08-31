n, m = [ int(i) for i in input().split() ]

blubs = set()
for i in range(n):
    for item in input().split()[1:]:
        blubs.add(item)

print('%s' % ('YES' if len(blubs) == m else 'NO'))
