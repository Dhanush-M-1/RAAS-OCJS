s = input().split()
d = { s[0]:s[0], s[1]:s[1] }
print(" ".join(d.keys()))
for _ in range(int(input())):
    s = input().split()
    if s[0] in d: del d[s[0]]
    else: d[s[0]] = s[0]
    if s[1] in d: del d[s[1]]
    else: d[s[1]] = s[1]
    print(" ".join(d.keys()))
    