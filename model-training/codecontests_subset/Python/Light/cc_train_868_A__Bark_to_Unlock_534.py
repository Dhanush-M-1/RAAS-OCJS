p = input()
n = int(input())
s = []
for _ in range(n):
    s.append(input())
if p in s:
    print('YES')
    exit(0)
else:
    for i in range(n):
        if s[i][1] == p[0]:
            for j in range(n):
                if s[j][0] == p[1]:
                    print('YES')
                    exit(0)
print('NO')

