s = input()
n = int(input())
flag1, flag2 = False, False
for i in range(n):
    a = input()
    if s == a:
        flag1, flag2 = True, True

    if s[0] == a[1]:
        flag1 = True
    if s[1] == a[0]:
        flag2 = True

if flag1 and flag2:
    print("YES")
else:
    print("NO")