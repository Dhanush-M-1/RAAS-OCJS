for i in range(int(input())):
    s = input()
    x = list(map(int, input().split()))
    if x[0] + x[1] <= x[-1]:
        print(1, 2, len(x), sep=" ")
    else:
        print(-1)