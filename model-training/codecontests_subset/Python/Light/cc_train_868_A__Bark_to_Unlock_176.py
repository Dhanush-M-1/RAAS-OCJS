import sys
s = input()
n = int(input())
p = q = 0
for i in range(n):
    s2 = input()
    if n == 1:
        if s2 == s or s2 == s[::-1]:
            p = q = 1

    else:
        if s[0] == s2[1]:
            p = 1
        if s[1] == s2[0]:
            q = 1
        if s2 == s or s2 == s[::-1]:
            p = q = 1
if p + q == 2:
    print('YES')
else:
    print('NO')
