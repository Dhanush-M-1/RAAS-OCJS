s = input()
n = int(input())

l = []
for i in range(n):
    x = input()
    l.append(x)

for i in l :
    for j in l :
        if s in i + j:
            print('YES')
            exit()

print('NO')