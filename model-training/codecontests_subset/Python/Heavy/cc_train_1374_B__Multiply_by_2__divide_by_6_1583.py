import sys, math

input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    a = int(input())
    if a == 1:
        print(0)
    else:
        ans = 0
        if a != 3:
            while True:
                if a % 6 == 0:
                    a //= 6
                    ans += 1
                else:
                    if a % 3 == 0:
                        a*=2
                        ans += 1
                    else:
                        ans = -1
                        break
                if a == 1:
                    break
            print(ans)
        else:
            print(2)