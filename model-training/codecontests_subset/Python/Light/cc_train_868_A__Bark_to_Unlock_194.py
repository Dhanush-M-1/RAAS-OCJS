p = input()
n = int(input())
a = []
for _ in range(n):
    s = input()
    if s == p or (s[0] == p[1] and p[0] == s[1]):
        print('YES')
        exit()
    a.append(s)
for i in range(n):
    for j in range(i+1, n):
        if a[i][1] == p[0] and a[j][0] == p[1]:
            print('YES')
            exit()
            break
        if a[j][1] == p[0] and a[i][0] == p[1]:
            print('YES')
            exit()
            break
print('NO')