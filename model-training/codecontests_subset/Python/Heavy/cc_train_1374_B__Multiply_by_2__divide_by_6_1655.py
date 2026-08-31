from math import log,pow
for _ in range(int(input())):
    n = int(input())
    if n == 1:
        print(0)
    else:
        if n % 3 != 0:
            print(-1)
        else:
            num = n
            steps = 0
            flag = True
            while num > 0 and num != 1:
                if num % 6 == 0:
                    steps += 1
                    num //= 6
                else:
                    if num % 3 != 0:
                        break
                    else:
                        num *= 2
                        steps += 1
            if num != 1:
                print(-1)
            else:
                print(steps)