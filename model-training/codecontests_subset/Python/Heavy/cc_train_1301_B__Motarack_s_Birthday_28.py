for t in range (int(input())):
    n=int(input())
    a=list(map(int, input().split()))
    ma=0
    b=[]
    for i in range(n-1):
        if a[i]!=-1 and a[i+1]!=-1:
            if ma < abs(a[i]-a[i+1]):
                ma=abs(a[i]-a[i+1])
        else:
            if a[i]==-1 and a[i+1]!=-1:
                b.append(a[i+1])
            elif a[i]!=-1 and a[i+1]==-1:
                b.append(a[i])
    if b==[]:
        print('0', '1')
    else:
        mu = int ((max(b)-min(b)+1)/2)
        k=min(b)+mu
        m = max (mu,ma)
        print(m,k)