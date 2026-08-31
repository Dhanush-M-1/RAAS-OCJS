n,m,k=[int(x) for x in input().split(' ')]
per=(n*k+99)//100
print(max(0,per-m))