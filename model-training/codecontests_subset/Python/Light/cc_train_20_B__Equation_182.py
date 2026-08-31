import math

A, B, C = map(int, input().split(" "))
if A == 0:
    if B == 0:
        if C == 0:
            print(-1)
        else:
            print(0)
    else:
        print(1)
        print(-C / B)
else:
    D = B * B - 4 * A * C
    if D < 0:
        print(0)
    elif D == 0:
        print(1)
        print(-B / (2 * A))
    else:
        X = (-B + math.sqrt(D)) / (2 * A)
        Y = (-B - math.sqrt(D)) / (2 * A)

        if X > Y:
            X, Y = Y, X
        print(2)
        print("{:.6f}".format(X))
        print("{:.6f}".format(Y))

