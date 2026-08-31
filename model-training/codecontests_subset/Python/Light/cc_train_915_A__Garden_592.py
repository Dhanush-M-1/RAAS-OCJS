n, k = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]
a.sort(reverse=True)

for i in a:
    if k % i == 0:
        print(k // i)
        exit(0)
