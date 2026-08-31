for _ in range(int(input())):
    n = int(input())
    l = list(map(int, input().split()))

    if l[0] + l[1] <= l[n - 1]:
        print(1,end=" ")
        print(2,end=" ")
        print(n)
    else:
        print(-1)