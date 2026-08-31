n, k = list(map(int, input().split()))
a = list(map(int, input().split()))
a.sort()
for x in reversed(a):
    if k%x == 0:
        print(k//x)
        exit()

