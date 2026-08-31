s = input()
n = int(input())
a = []
for i in range(n):
    a.append(input())
for i in a:
    for j in a:
        if s in i + j:
            print('YES')
            exit()
print('NO')
