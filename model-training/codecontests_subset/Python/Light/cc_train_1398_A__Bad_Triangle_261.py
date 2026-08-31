t = int(input().split()[0])
for case in range(t):
    n = int(input().split()[0])
    a = list(map(int,input().split()))
    if a[0] + a[1] <= a[n-1]:
        print("1 2 "+ str(n))
    else:
        print("-1")
