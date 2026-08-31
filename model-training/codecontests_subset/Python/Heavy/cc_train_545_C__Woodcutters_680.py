n=int(input())
x=[]
h=[]
for i in range(n):
    s=input()
    s1=s.split()

    x.append(int(s1[0]))
    h.append(int(s1[1]))

dp=[[0 for i in range(3)] for j in range(len(x))]

for i in range(len(x)):

    for j in range(3):

        if j==0:

            if i>0:
                dp[i][j]=max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
            else:
                dp[i][j]=0

        elif j==1:


            if i>0:
                if (x[i]-h[i])>x[i-1]:
                    
                    dp[i][j]=max(dp[i-1][0],dp[i-1][1])

                if (h[i]+h[i-1])<(x[i]-x[i-1]):

                    dp[i][j]=max(dp[i][j],dp[i-1][2])

            dp[i][j]=dp[i][j]+1

        else:

            
            if i+1<len(x) and (x[i]+h[i])<x[i+1]:

                dp[i][j]=max(dp[i-1][0],dp[i-1][1],dp[i-1][2])+1
            elif i+1==len(x):
                dp[i][j]=max(dp[i-1][0],dp[i-1][1],dp[i-1][2])+1
                


if len(x)==1:
    print(1)
else:
    
    print(max(dp[len(x)-1][0],dp[len(x)-1][1],dp[len(x)-1][2]))
                
