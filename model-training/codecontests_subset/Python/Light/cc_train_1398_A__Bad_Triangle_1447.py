for i in range(int(input())):
    n=int(input())
    a=sorted(map(int,input().split()))
    print("1 2 %d" % n  if(a[0]+a[1]<=a[n-1]) else -1)