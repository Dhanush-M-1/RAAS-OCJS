r1, r2 = list(map(int, input().split()))
c1, c2 = list(map(int, input().split()))
d1, d2 = list(map(int, input().split()))
l1 = []
l2 = []
for i in range(1, r1 + 1):
    for j in range(1, r1 + 1):
        if i + j == r1 and i < 10 and j < 10:
            l1.append([j, i])
for i in range(1, r2 + 1):
    for j in range(1, r2 + 1):
        if i + j == r2 and i < 10 and j < 10:
            l2.append([j, i])
found = False

for i in l1:
    for j in l2:
        r1c1 = i[0]
        r1c2 = i[1]
        r2c1 = j[0]
        r2c2 = j[1]



        if ((r1c1 + r2c1) == c1) and ((r1c2 + r2c2) == c2) and ((r1c1 + r1c2) == r1) and ((r2c1 + r2c2) == r2) and ((r1c1 + r2c2) == d1) and ((r2c1 + r1c2) == d2) and r1c1 != r1c2 and r1c1 != r2c1 and r1c1 != r2c2 and r1c2 != r2c1 and r1c2 != r2c2 and r2c1 != r2c2:
            print('{} {}'.format(r1c1, r1c2))
            print('{} {}'.format(r2c1, r2c2))
            exit()
print(-1)