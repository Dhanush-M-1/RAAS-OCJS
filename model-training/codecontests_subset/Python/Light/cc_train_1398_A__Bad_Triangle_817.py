for _ in range(int(input())):
    n = int(input())
    a = [int(x) for x in input().split()]
    print('1 2', n) if a[n-1] >= a[0] + a[1] else print('-1')