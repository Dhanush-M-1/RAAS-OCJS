def func(n):
    count = 0
    while n[0] != count:
        count += 1
        if count % n[1] == 0:
            n[0] += 1
    print(count)
n = list(map(int,input().split()))
func(n)