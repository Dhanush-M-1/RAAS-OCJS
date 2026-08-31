n = int(input())
line1 = [int(i) for i in input().split()]
line2 = [int(i) for i in input().split()]
line3 = [int(i) for i in input().split()]
errors1 = {}
errors2 = {}
errors3 = {}
for i in line1:
    if i not in errors1:
        errors1[i] = 0
    else: errors1[i] += 1
for i in line2:
    if i not in errors2:
        errors2[i] = 0
    else: errors2[i] += 1
for i in line3:
    if i not in errors3:
        errors3[i] = 0
    else: errors3[i] += 1
for i in errors1:
    if i not in errors2 or errors1[i]-errors2[i] == 1:
        print(i)
for i in errors2:
    if i not in errors3 or errors2[i]-errors3[i] == 1:
        print(i)