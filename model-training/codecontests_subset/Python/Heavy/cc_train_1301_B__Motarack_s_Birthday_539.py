t=int(input())
while t:
    n=int(input())
    a=input().split()
    maxi=-1
    mini=10**9+1
    for i in range(n):
        if(int(a[i])==-1):
            if(i-1>=0):
                if(int(a[i-1])!=-1):
                    mini=min(mini,int(a[i-1]))
                    maxi=max(maxi,int(a[i-1]))
            if(i+1<=n-1):
                if(int(a[i+1])!=-1):
                    mini=min(mini,int(a[i+1]))
                    maxi=max(maxi,int(a[i+1]))
    if(True):  
        for i in range(n):
            a[i]=int(a[i])
            if(a[i]==-1):a[i]=(maxi+mini)//2
        lol=0   
        for i in range(1,n):
            lol=max(lol,abs(a[i]-a[i-1]))
        print(lol,(maxi+mini)//2)    
    t-=1