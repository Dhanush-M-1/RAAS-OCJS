for _ in range(int(input())):
    n=int(input())
    if n==1:
        p, c = map(int, input().split())
        if c>p:
            print("NO")
            continue
        print("YES")
        continue

    a,b=[],[]
    d=0
    for _ in range(n):
        p,c=map(int,input().split())
        a.append(p)
        b.append(c)
    for i in range(n-1):
        if b[i]>a[i]:
            d+=1
            break
        if b[i+1]-b[i]>a[i+1]-a[i]:
            d+=1
            break
        if a[i+1]>a[i] and b[i+1]>=b[i]:

            continue
        if a[i+1]==a[i] and b[i+1]==b[i]:

            continue
        d+=1
        break
    if d==1:
        print("NO")
    if d==0:
        print("YES")
