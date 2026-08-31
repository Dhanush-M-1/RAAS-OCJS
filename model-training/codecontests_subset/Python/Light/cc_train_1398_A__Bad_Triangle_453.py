for i in range(int(input())):
    n = int(input())
    array = list(map(int, input().split()))

    if(array[0] + array[1] <= array[-1]):
        print(1, 2, n)
    else:
        print(-1)
