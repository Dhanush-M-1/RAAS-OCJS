for z in range(int(input())):
    n=int(input())
    r=list(map(int,input().split()))
    c=list(map(int,input().split()))
    a=[]
    b=0
    a1=0
    for i in range(n):
        b=max(b,r[i]-c[i])
        if (r[i]-c[i])%2==0:
            a.append([r[i]-c[i],r[i]])
            a1+=1
    b//=2
    c=0
    if a1!=0:
        a.sort()
        for i in range(1,len(a)):
            if a[i][0]!=a[i-1][0]:
                if a[i-1][0]==0 and r[0]!=1:
                    b+=a[c][1]-1
                b+=a[i-1][1]-a[c][1]
                c=i
        b+=a[-1][1]-a[c][1]
        if a[-1][0]==0 and r[0]!=1:
            b+=a[c][1]-1
    print(b)