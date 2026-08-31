T = [[] for i in range(4)]
for i in range(4):
    T[i] = list(input())


for k in range(4):
    for i in range(2):
        tmp = 0
        for j in range(3):
            if T[k][i + j] == '.':
                tmp += 1
            elif T[k][i + j] == 'o':
                tmp = 0
                break

        if tmp == 1:
            print('YES')
            exit()


for k in range(4):
    for i in range(2):
        tmp = 0
        for j in range(3):
            if T[i + j][k] == '.':
                tmp += 1
            elif T[i + j][k] == 'o':
                tmp = 0
                break

        if tmp == 1:
            print('YES')
            exit()

for s, t in [(0, 0), (1, 0), (0, 1), (1, 1)]:
    tmp = 0
    for j in range(3):
        if T[s + j][t + j] in '.':
            tmp += 1
        elif T[s + j][t + j] == 'o':
            tmp = 0
            break

    if tmp == 1:
        print('YES')
        exit()

for s, t in [(0, 3), (0, 2), (1, 3), (1, 2)]:
    tmp = 0
    for j in range(3):
        if T[s + j][t - j] == '.':
            tmp += 1
        elif T[s + j][t - j] == 'o':
            tmp = 0
            break

    if tmp == 1:
        print('YES')
        exit()

print('NO')
