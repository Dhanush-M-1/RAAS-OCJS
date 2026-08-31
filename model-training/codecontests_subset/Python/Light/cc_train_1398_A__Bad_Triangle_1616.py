from sys import stdin
tt = int(stdin.readline())

for loop in range(tt):

    n = int(stdin.readline())
    a = list(map(int,stdin.readline().split()))

    if a[0] + a[1] <= a[n-1]:
        print (1,2,n)
    else:
        print (-1)