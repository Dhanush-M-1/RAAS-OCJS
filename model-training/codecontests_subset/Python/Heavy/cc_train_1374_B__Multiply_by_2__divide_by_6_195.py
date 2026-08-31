# x, n = (int(var) for var in input().split())
# pos = [int(var) for var in input().split()]
# Map = {(0, n)}
import math

t = int(input())
for _ in range(t):

    n = int(input())
    if n== 1:
        print(0)
    elif n % 3 == 0 :
        pow2, pow3 = 0, 0
        while n%2 == 0 :
            pow2 += 1
            n = n//2

        while n%3 == 0 :
            pow3 += 1
            n = n//3

        if n == 1 :
            if pow2 <= pow3 :
                print((pow3-pow2) + (pow3))
            else:
                print(-1)
        else:
            print(-1)


    else:
        print(-1)