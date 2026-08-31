from sys import stdin,stdout
for _ in range(int(stdin.readline())):
    n=int(stdin.readline())
    # =map(int,stdin.readline().split())
    a=list(map(int,stdin.readline().split()))
    x=a[0];y=a[1];z=a[-1]
    if x+y>z and y+z>x and x+z>y:
        print(-1)
        continue
    print(1,2,n)