n=int(input())
x=[]
h=[]
for i in range(n):
    x1,h1=map(int,input().split())
    x.append(x1)
    h.append(h1)
dp = [[0 for i in range(3)] for j in range(n)]
for i in range(n):
    if i==0:
        dp[i][0]=0
        dp[i][1]=1
        try:
            if x[i]+h[i]<x[i+1]-h[i+1]:
                dp[i][2]=1

            elif x[i]+h[i]<x[i+1]:
                dp[i][2]=1

            else:
                dp[i][2]= 0
        except:
            dp[i][2]=1
    
    elif i==n-1:
        dp[i][0]=max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        dp[i][2]=1+ max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        if(x[i]-h[i]>x[i-1]+h[i-1]):
            dp[i][1]= 1+ max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        
        elif x[i]-h[i]>x[i-1]:
            dp[i][1]=1+ max(dp[i-1][0],dp[i-1][1]);
        else:
            dp[i][1]= max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        
    else:
        dp[i][0]=max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        
        if x[i]+h[i]<x[i+1]-h[i+1]:
            dp[i][2]=1+ max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        
        elif x[i]+h[i]<x[i+1]:
            dp[i][2]=1+ max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        
        else:
            dp[i][2]= max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        
        if x[i]-h[i]>x[i-1]+h[i-1]:
            dp[i][1]= 1+ max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        
        elif x[i]-h[i]>x[i-1]:
            dp[i][1]=1+ max(dp[i-1][0],dp[i-1][1]);
        
        else:
            dp[i][1]= max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
        

final = max(dp[n-1][0],dp[n-1][1],dp[n-1][2])
print(final)