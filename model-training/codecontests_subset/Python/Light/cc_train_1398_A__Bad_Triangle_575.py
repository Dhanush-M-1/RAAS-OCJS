#list (map(int, input().split()))
rw = int(input())
for qwe in range(rw):
    n = int(input())
    a = list(map(int, input().split()))
    a.reverse()
    if a[0] >= a[n - 2] + a[n - 1]:
        print(1, 2, n)
    else:
        print(-1)