s = input()
c1 = c2 = False
for i in range(int(input())):
    a = input()
    if (a == s or a[::-1] == s):
        print("YES")
        exit()
    if a[1] == s[0]: c1 = True
    if a[0] == s[1]: c2 = True
    if c1&c2: print("YES"); exit()
print('NO') 