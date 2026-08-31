t = int(input())
while t:
    n = int(input())
    a = [int(i) for i in input().split()]
    if a[0] + a[1] <= a[len(a)-1]:
        print(1, 2, len(a))
    else:
        print(-1)
    t -= 1