n = int(input())
a = [int(i) for i in input().split()]

e = []
o = []

for i in a:
    if i % 2 == 0:
        e.append(i)
    else:
        o.append(i)

o.sort(reverse = True)
e.sort(reverse = True)

poso, pose = 0, 0
player = 0

while True == True:
    if player == 0:
        if pose < len(e):
            pose += 1
        else:
            break
    else:
        if poso < len(o):
            poso += 1
        else:
            break
    player ^= 1

sum1 = 0

if poso == len(o):
    for i in range(pose, len(e), 1):
        sum1 += e[i]
else:
    for i in range(poso, len(o), 1):
        sum1 += o[i]

poso, pose = 0, 0
player = 1

while True == True:
    if player == 0:
        if pose < len(e):
            pose += 1
        else:
            break
    else:
        if poso < len(o):
            poso += 1
        else:
            break
    player ^= 1

sum2 = 0

if poso == len(o):
    for i in range(pose, len(e), 1):
        sum2 += e[i]
else:
    for i in range(poso, len(o), 1):
        sum2 += o[i]

print(min(sum1, sum2))