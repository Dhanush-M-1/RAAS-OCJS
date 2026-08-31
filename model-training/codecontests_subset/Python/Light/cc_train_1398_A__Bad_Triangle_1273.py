t = int(input())
for l in range(t):
    n = int(input())
    ar = list(map(int,input().strip().split()))
    if ar[0]+ar[1]<=ar[-1]:
        print(1,2,len(ar))
    else:
        print(-1)