
def num_trees(n,x,h):
    if n<3: return n
    dp=[[0,0] for i in range(n-1)]
    dp[0]=[1,x[0]]#num trees, position
    for i in range(1,n-1):
        # standing still
        if (x[i]-h[i])<x[i-1] and (x[i]+h[i])>x[i+1]:
            dp[i]=[dp[i-1][0],x[i]]
        #falling left
        elif (x[i]-h[i])>x[i-1] and (x[i]-h[i])>dp[i-1][1]:
            # if x[i]==34: print("here 1")
            dp[i] = [dp[i-1][0]+1,x[i]]
        elif (x[i]+h[i])<x[i+1]:
            dp[i] = [dp[i - 1][0] + 1, x[i]+h[i]]
        else:
            dp[i] = [dp[i - 1][0], x[i]]
    # print([(x[i],dp[i]) for i in range(len(dp))])
    # print([dp[i][0] for i in range(len(dp))])
    return dp[n-2][0]+1


##########################
n=int(input())
x,h=[],[]
for _ in range(n):
    a,b = [int(i) for i in input().split(" ")]
    x.append(a);h.append(b)

print(num_trees(n,x,h))