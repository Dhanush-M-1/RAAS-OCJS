import sys
n,k=map(int,input().split())
a=list(map(int,input().split()))

a.sort(reverse=True)

for x in a:
    if k==(k//x)*x:
        print(k//x)
        sys.exit(0)
