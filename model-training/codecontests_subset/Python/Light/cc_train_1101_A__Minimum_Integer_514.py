q = int(input())
for i in range(q):
    x = list(map(int, input().split()))
    if x[2] < x[0]:
        print(x[2])
    else:
        print(x[1] + x[2] - x[1] % x[2])
