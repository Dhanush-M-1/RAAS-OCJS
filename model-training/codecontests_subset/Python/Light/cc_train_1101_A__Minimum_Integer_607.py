n = int(input())
for i in range(n):
    num = input().split(' ')
    l, r, d = int(num[0]), int(num[1]), int(num[2])
    if l <= d:
        print(r + d - r % d)
    else:
        print(d)
