n, m = map(int, input().split())

buttns = []

for i in range(n):
    butt = input().split()[1:]
    if (len(butt) != 0):
        butt = set(butt)
        buttns.append((len(butt), butt))

buttns.sort()
used = 0
lamps = set()
while ((len(buttns) != 0) and (used <= n)) and (len(lamps) != m):
    curr = buttns.pop()
    lamps = lamps | curr[1]
    used += 1
    for i in range(0, len(buttns)):
        buttns[i] = (len(buttns[i][1] - lamps), buttns[i][1])
    buttns.sort()

if (used <= n) and (len(lamps) == m):
    print('YES')
else:
    print('NO')