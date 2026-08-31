def check(str1, num, k):
    fl = False
    for j in range(len(num)):
        m = str1 + num[j]
        if m[1:3] == password:
            fl = True
    return fl

password = input()
n = int(input())
num = []
flag = False
for i in range(n):
    a = input()
    if a == password:
        print("YES")
        flag = True
    else:
        num.append(a)
if len(num) == 1:
    q = num[0] + num[0]
    if q[1:3] == password:
        print("YES")
        flag = True
if not flag:
    for i in range(len(num)):
        if check(num[i], num, i):
            print("YES")
            flag = True
            break
if not flag:
    print("NO")