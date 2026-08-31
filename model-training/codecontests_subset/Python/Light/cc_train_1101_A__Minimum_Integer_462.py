

for i in range(int(input())):
    a = [int(a) for a in input().split()]
    j = 1
    if a[2] < a[0] or a[2] > a[1]:
        print(a[2])
    else:
        print((a[1] // a[2]) * a[2] + a[2])