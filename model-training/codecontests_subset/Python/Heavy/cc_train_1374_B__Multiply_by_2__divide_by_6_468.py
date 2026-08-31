t = int(input())
if 1 <= t <= 2*(10**4):
    for i in range(t):
        n = int(input())
        if 1 <= n <= (10**9):
            count = 0
            if n == 1:
                print(0)
            else:
                while n != 1:
                    if n > 10**9:
                        print(-1)
                        break
                    if n % 6 == 0:
                        n /= 6
                        count += 1
                    else:
                        n *= 2
                        count += 1
                else:
                    print(count)