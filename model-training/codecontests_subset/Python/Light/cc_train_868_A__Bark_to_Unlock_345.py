s = input()
n = int(input())

f1 = f2 = False
l = []
for i in range(n):
    x = input()
    if x[0] == s[1] :
        f1 = True

    if x[1] == s[0]:
        f2 = True
    l.append(x)

#print(l)
if s in l :
    print('YES')
    exit()
else:
    if f1 and f2 :
        print('YES')
    else:
        print('NO')

