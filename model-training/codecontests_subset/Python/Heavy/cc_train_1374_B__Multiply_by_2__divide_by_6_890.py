import sys
import math
t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    cnt_2 = 0
    cnt_3 = 0
    if n == 1:
        print(0)
        continue
    if n >= 2:
        while n % 2 == 0:
            cnt_2 += 1
            n = n // 2

        while n % 3 == 0:
            cnt_3 += 1
            n = n // 3
        if n == 1:
            if cnt_2 == cnt_3:
                print(cnt_3)
            elif cnt_2 < cnt_3:
                print(cnt_3 + cnt_3 - cnt_2)
            else:
                print(-1)

        else:
            print(-1)
