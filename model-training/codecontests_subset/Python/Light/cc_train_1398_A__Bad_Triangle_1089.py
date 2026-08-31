for query in range(int(input())):
    n=int(input())
    b=input().split()
    a=[]
    for x in range(n):
        a.append((int(b[x]),x+1))
    a=sorted(a)
    if a[0][0]+a[1][0]<=a[n-1][0]:
        print(str(a[0][1])+" "+str(a[1][1])+" "+str(a[n-1][1]))
    else:
        print(-1)
    