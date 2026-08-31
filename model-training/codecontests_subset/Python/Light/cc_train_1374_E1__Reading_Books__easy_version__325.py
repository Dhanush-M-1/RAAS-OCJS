from sys import *
n, k = [int(x) for x in stdin.readline().split()]

lk1 = []
lk2 = []
lk3 = []

for _ in range (n):
    time, x, y = [int(x) for x in stdin.readline().split()]

    if x == 1 and y == 1:
        lk3.append(time)
    elif x == 1:
        lk1.append(time)
    elif y == 1:
        lk2.append(time)

lk1.sort()
lk2.sort()

cnt = min(len(lk1), len(lk2))

for i in range(cnt):
    lk3.append(lk1[i] + lk2[i])

lk3.sort()

if len(lk3) < k:
    stdout.write(str(-1) + '\n')
else:
    sum = 0

    for i in range (k):
        sum += lk3[i]

    stdout.write(str(sum) + '\n')
