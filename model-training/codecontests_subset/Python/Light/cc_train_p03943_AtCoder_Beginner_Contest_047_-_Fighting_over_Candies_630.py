a=list(map(int,input().split()))
a.sort()
print('YNeos'[(a[0]+a[1]!=a[2])::2])