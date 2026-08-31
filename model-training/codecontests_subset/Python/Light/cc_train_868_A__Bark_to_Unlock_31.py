##a = list(map(int, input().split()))
##print(' '.join(map(str, res)))

pw = input()
n = int(input())
w = list()
for _ in range(n):
    w.append(input())

for _ in range(n):
    if pw in w:
        print('YES')
        exit(0)

for i in range(n):
    for j in range(n):
        if w[i][1] == pw[0] and w[j][0] == pw[1]:
            print('YES')
            exit(0)
print('NO')

