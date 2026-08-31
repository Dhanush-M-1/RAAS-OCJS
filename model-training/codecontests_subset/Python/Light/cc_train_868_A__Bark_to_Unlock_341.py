password = input()
n = int(input())
same, fl, lf = [False] * 3
for i in range(n):
    k = input()
    if k[0] == password[0]:
        if k[1] == password[1]:
            same = True
    if k[0] == password[1]: fl = True
    if k[1] == password[0]: lf = True
if (fl and lf) or same:
    print("YES")
else:
    print("NO")
