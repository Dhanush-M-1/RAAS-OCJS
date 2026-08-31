a, b = [int(i) for i in input().strip().split()]

total = 0
rest = 0

while True:

    if a == 0:
        print(total)
        break

    total += a

    tmp = (a + rest) % b
    a = (a + rest) // b

    rest = tmp