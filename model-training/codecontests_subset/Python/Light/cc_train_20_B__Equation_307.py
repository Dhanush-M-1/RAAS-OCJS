import math

A, B, C = [int(i) for i in input().split()]
X = B * B - 4 * A * C

if A == 0 and B == 0 and C == 0:
    print(-1)

elif A == 0 and B == 0:
    print(0)

elif A == 0:
    print(1)
    print('{0:.10f}'.format(-C / B, 6))

elif X < 0:
    print(0)

elif X == 0:
    print(1)
    print('{0:.10f}'.format(-B / (2 * A)))

else:
    print(2)
    ans = sorted([-(B + math.sqrt(X)) / (2 * A), -(B - math.sqrt(X)) / (2 * A)])
    print('{0:.10f}'.format(ans[0]))
    print('{0:.10f}'.format(ans[1]))
