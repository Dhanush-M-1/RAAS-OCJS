s = input()
n = int(input())
a = []
for i in range(n):
    a.append(input())
fc = 0
sc = 0
for i in range(n):
    fb = a[i][0]
    sb = a[i][1]
    if fb + sb == s or sb + fb == s:
        fc = 1
        sc = 1
        break
    if fb == s[1] and fc == 0:
        fc = 1
    if sb == s[0] and sc == 0:
        sc = 1
    
    if fc == 1 and sc == 1:
        break

if fc == 1 and sc == 1:
    print('YES')
else:
    print('NO')


    