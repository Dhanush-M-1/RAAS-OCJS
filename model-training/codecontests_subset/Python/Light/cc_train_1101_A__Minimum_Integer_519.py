n = int(input())
for _ in range(n):
    numbers = [int(i) for i in input().split()]
    l = numbers[0]
    r = numbers[1]
    d = numbers[2]
    if d < l or d > r:
        print(d)
    else:
        print((r // d + 1) * d)