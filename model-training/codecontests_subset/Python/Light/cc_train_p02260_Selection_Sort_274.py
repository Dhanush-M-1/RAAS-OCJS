count = 0
input()
num = [int(n) for n in input().split()]
for i in range(len(num)):
    minj = i
    for j in range(i, len(num)):
        if num[j] < num[minj]:
            minj = j
    if minj != i:
        num[i], num[minj] = num[minj], num[i]
        count += 1
print(*num)
print(count)