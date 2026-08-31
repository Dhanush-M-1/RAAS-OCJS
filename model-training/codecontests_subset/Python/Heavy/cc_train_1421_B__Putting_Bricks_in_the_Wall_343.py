from sys import stdin,stdout
# def valid(x,y):
#     return 0<=x<n and 0<=y<n
# def fn(x,y,dig):
#     global ans
#     vis[x][y]=1
#     if a[x][y]=='F':return True
#     for xx,yy in zip([1,-1,0,0],[0,0,1,-1]):
#         if valid(x+xx,y+yy) and not vis[x+xx][y+yy] and (a[x+xx][y+yy] in ['F',dig]):
#             # if a[x+xx][y+yy]=='F':
#             #     ans+=[[x+1,y+1]]
#             #     return True
#             if fn(x+xx,y+yy,dig)==True:return True
#     return False
for _ in range(int(stdin.readline())):
    n=int(stdin.readline())
    # a=[list(map(int,stdin.readline().split())) for _ in range(n)]
    a=[list(input()) for _ in range(n)]
    ans=[]
    # for i in range(n):
    #     for j in range(n):
    #         if i==j==0 or (i==j==n-1):continue
    #
    #         ori=a[i][j]
    #         a[i][j]='1' if ori=='0' else '0'
    #         if fn(0,0,ori)==False:
    #             ans+=[[i+1,j+1]]
    #         a[i][j]=ori
    #         if len(ans)>=2:break
    #     if len(ans) >= 2: break
    # vis = [[0 for _ in range(n)] for _ in range(n)]
    # fn(0,0,'0')
    # vis = [[0 for _ in range(n)] for _ in range(n)]
    # fn(0,0,'1')
    # print(len(ans))
    # for k,v in ans:
    #     print(k,v)
    if a[0][1]==a[1][0]=='0':
        if a[-2][-1]=='0':
            ans+=[[n-1,n]]
        if a[-1][-2]=='0':
            ans+=[[n,n-1]]
    elif a[0][1]==a[1][0]=='1':
        if a[-2][-1]=='1':
            ans+=[[n-1,n]]
        if a[-1][-2]=='1':
            ans+=[[n,n-1]]
    elif a[-1][-2]==a[-2][-1]=='0':
        if a[0][1]=='0':
            ans+=[[1,2]]
        if a[1][0]=='0':
            ans+=[[2,1]]
    elif a[-1][-2]==a[-2][-1]=='1':
        if a[0][1]=='1':
            ans+=[[1,2]]
        if a[1][0]=='1':
            ans+=[[2,1]]
    else:
        if a[0][1]!=a[-1][-2]:
            ans+=[[1,2],[n,n-1]]
        elif a[0][1]!=a[-2][-1]:
            ans+=[[1,2],[n-1,n]]
    print(len(ans))
    for k,v in ans:
        print(k,v)
