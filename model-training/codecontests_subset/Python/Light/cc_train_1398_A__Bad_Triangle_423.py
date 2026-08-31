def isTriangle(a, b, c):
    if a+b <= c or a+c <= b or b+c <= a:
        return False
    return True

t = int(input())

while t != 0:
    t -= 1

    n = int(input())
    arr = [int(x) for x in input().split()]

    if not isTriangle(arr[0], arr[1], arr[-1]):
        print ("1 2", n)
    else:
        print(-1)

