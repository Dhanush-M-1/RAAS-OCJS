for _ in range(int(input())):
    n = int(input())
    p, w = map(int, input().split())
    isValid = True
    if w > p:
        isValid = False
    for i in range(n - 1):
        p1, w1 = map(int, input().split())
        if p1 < p:
            isValid = False
        elif w1 > p1:
            isValid = False
        elif w1 < w:
            isValid = False
        elif (w1 - w) > (p1 - p):
            isValid = False
        p = p1
        w = w1
    if not isValid:
        print("NO")

    else:
        print("YES")