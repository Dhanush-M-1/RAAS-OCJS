s = input()
n = int(input())
ok = [False,False]
ok1 = False
for _ in range(n):
    t = input()
    if s == t:
        ok1 = True
    if s[0] == t[1]: 
        ok[0] = True
    if s[1] == t[0]:
        ok[1] = True
if ok1 or (ok[0] and ok[1]):
    print("YES")
else:
    print("NO")
