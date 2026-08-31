n = int(input())
result = []
for i in range(n):
    count = 0
    num = int(input())
    flag = 0
    if num == 1:
        result.append(0)
    while num > 0 and num != 1:
        if num % 6 == 0:
            num = num / 6
            count += 1
        elif num % 3 == 0:
            num *= 2
            count += 1
        else:
            break
        if num == 1:
            result.append(count)
            flag = 1
            break
    if flag == 0 and num != 1:
        result.append(-1)

for j in result:
    print(j)