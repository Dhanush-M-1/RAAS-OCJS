for i in range(int(input())):
    n=int(input())
    a=[]
    b=[]
    for i in range(n):
        c,d=map(int,input().split())
        a.append(c)
        b.append(d)
    f=False
    if n==1:
        if a[0]>=b[0]:
            print("YES")
        else:
            print("NO")
    else:
        for i in range(n-1):
            if (a[i]>a[i+1] or b[i]>b[i+1]) or (a[i+1]==a[i] and b[i+1]!=b[i]) or (a[i]<b[i]) or (a[i+1]-a[i]<b[i+1]-b[i]):
                print("NO")
                f=True
                break
        if f==False:
            if a[-1]<b[-1]:
                print("NO")
            else:
                print("YES")