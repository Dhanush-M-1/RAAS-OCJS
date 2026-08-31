for i in range(int(input())):
    n = int(input())
    l = list(map(int, input().split()))
    print(f'1 2 {n}' if l[0] + l[1] <= l[n - 1] else -1)