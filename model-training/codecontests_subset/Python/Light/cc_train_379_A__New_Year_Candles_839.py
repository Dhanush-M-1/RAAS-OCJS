def candles(m,n):
    if(m<n):
        print(m)
    else:
        h=m
        while(m>=n):
            ans=int(m/n)
            rem=int(m%n)
            h=ans+h
            m=ans+rem
        print(int(h))
a=[]
b=[]
a,b=input().split()
a=int(a)
b=int(b)
candles(a,b)