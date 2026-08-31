T = int(input())

for t in range(1, T + 1):
    N = int(input())
    answer = 0
    div_2 = 0
    div_3 = 0

    x = N
    while x % 3 == 0:
        x = x // 3
        div_3 += 1
    while x % 2 == 0:
        x =x // 2

    if x != 1:
        print(-1)
        continue

# 12345
    x = N
    while x % 2 == 0:
        x = x // 2
        div_2 += 1

    if div_3 < div_2:
        print(-1)
        continue

    answer = div_2 + 2 * div_3

    N = N * (2 ** (div_3 - div_2))

    answer = 0
    while N > 1:
        N = N // 6
        answer += 1

    print(answer + div_3 - div_2)