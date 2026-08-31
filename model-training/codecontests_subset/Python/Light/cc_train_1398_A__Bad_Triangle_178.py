t = int(input())

for _ in range(t):
    n = int(input())
    inp = [int(i) for i in input().split()]

    if inp[0]+inp[1] <= inp[n-1]:
        print(1, 2, n)
    else:
        print(-1)
