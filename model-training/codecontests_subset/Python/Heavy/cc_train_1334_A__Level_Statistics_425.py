t = int(input())
for t_itr in range(0,t):
    n = int(input())
    plays = [-1]*n
    clears = [-1]*n
    pmax = float("-inf")
    cmax = float("-inf")
    flag = 1
    plays[0],clears[0] = map(int,input().split())
    if(clears[0]>plays[0]):
        flag = 0
    for i in range(1,n):
        plays[i],clears[i] = map(int,input().split())
        if(plays[i]>pmax):
            pmax = plays[i]
        if(clears[i]>cmax):
            cmax = clears[i]
        if(plays[i]<plays[i-1] or clears[i]<clears[i-1] or clears[i]>pmax or ((clears[i]-clears[i-1]) > plays[i] - plays[i-1]) ):
            flag = 0
    print("YES" if flag==1 else "NO")