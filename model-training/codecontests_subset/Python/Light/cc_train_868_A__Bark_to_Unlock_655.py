s = input()
n = int(input())
r = []
for i in range(n):
    a = input()
    if (a == s or a[::-1] == s):
        print("YES")
        exit()
    r.append(a)
c1, c2 = False, False
for i in r:
    if i[1] == s[0]: c1 = True
    if i[0] == s[1]: c2 = True
    if c1&c2: print("YES"); exit()
print('NO') 