def compilationErrors():
    n = int(input())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    print(sum(a) - sum(b))
    a = list(map(int, input().split()))
    print(sum(b) - sum(a))

    del a
    del b
compilationErrors()