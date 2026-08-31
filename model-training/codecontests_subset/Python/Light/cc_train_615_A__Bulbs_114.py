n,m = [int(i) for i in input().split()]
b = []
for i in range(n):
    s = [int(k) for k in input().split()]
    if s[0] != 0:
        del s[0]
        for bulb in s:
            if not bulb in b:
                b.append(bulb)
if len(b) == m: print("YES\n")
else: print("NO\n")
