pw = input()
fc = False
lc = False
for _ in range(int(input())):
    s = input()
    if s == pw:
        fc = True
        lc = True
        break
    if s[0] == pw[1]:
        lc = True
    if s[1] == pw[0]:
        fc = True

if fc and lc:
    print("YES")
else:
    print("NO")

