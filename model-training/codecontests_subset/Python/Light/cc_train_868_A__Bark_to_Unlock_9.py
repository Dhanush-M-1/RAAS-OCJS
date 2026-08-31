pw = input()
n = int(input())
kash = []

for i in range(n):
    kash.append(input())

flag = False

for w in kash:
    if w == pw:
        flag = True
        break
    if w[1] == pw[0]:
        for z in kash:
            if pw in (w + z) or pw in (z + w):
                flag = True
                break

if flag == True:
    print('YES')
else:
    print('NO')