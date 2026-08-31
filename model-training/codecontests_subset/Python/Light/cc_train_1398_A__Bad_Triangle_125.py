from math import sqrt
t = int(input())


def area(a, b, c):
    p = (a+b+c)/2
    area = sqrt(p*(p-a)*(p-b)*(p-c))
    return area


while t:
    n = int(input())
    a = [int(x) for x in input().split()]
    flag = 0
    if a[0] + a[1] <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)
    t -= 1
