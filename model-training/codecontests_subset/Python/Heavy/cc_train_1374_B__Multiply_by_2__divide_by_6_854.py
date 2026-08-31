for _ in range(int(input())):
    default_n = int(input())
    n = default_n
    if n == 1:
        print(0)
        continue
    if n % 6 != 0 and (n * 2) % 6 != 0:
        print(-1)
        continue
    attempts = 0
    broken = 0
    while n != 1:
        while n % 6 != 0:
            n *= 2
            attempts += 1
            if attempts > 5 and n >= default_n:
                print(-1)
                broken = 1
                break
        if broken:
            break
        while n % 6 == 0:
            n //= 6
            attempts += 1
            if attempts > 5 and n >= default_n:
                print(-1)
                broken = 1
                break
        if broken:
            break
    if broken == 0:
        print(attempts)
