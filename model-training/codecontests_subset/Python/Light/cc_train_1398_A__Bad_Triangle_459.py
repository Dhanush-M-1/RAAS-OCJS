t = int(input())

for _ in range(t):
    n = int(input())

    num = list(map(int, input().split()))

    if num[0] + num[1] > num[n-1]:
        print("-1")
    else:
        print("{} {} {}".format(1, 2, n))
