l = []
for _ in range(int(input())):
    steps = 0
    number = int(input())
    if number == 1:
        l.append(str(0))
        continue
    if number % 3 != 0:
        l.append(str(-1))
        continue
    while number % 3 == 0:
        while number % 6 != 0:
            number = number * 2
            steps = steps + 1
        while number % 6 == 0:
            number = number // 6
            steps = steps + 1
    if number != 1:
        l.append(str(-1))
    else:
        l.append(str(steps))
print('\n'.join(l))