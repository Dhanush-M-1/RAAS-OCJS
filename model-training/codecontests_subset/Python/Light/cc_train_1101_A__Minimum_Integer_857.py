for i in range(int(input())):
    a = list(int(x) for x in input().split())
    print((a[2] >= a[0]) * (a[1] // a[2]) * a[2] + a[2])