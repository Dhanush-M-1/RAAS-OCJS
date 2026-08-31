s = str(input()).split()
n = int(s[0])
m = int(s[1])
bulbs = set()
for i in range(n):
    s = str(input()).split()
    mm = []
    for ii in range(1, len(s)):
        mm += [int(s[ii])]
        bulbs.add(int(s[ii]))
if len(bulbs) == m:
    print('YES')
else:
    print('NO')
