def solve(n):
    s=[input() for _ in range(n)]
    ans=[]
    cnt=0
    if s[0][1]==s[1][0] :
        if s[n-2][n-1]==s[0][1]:
            ans.append((n-1,n))
            cnt+=1
        if s[n-1][n-2]==s[0][1] :
            ans.append((n,n-1))
            cnt+=1
    elif s[n-1][n-2]==s[n-2][n-1] :
        if s[0][1]==s[n-1][n-2]:
            ans.append((1,2))
            cnt+=1
        if s[1][0]==s[n-1][n-2] :
            ans.append((2,1))
            cnt+=1
    else:
        if s[0][1]!='0' :
            ans.append((1,2))
            cnt+=1
        else:
            ans.append((2,1))
            cnt+=1
        if s[n-1][n-2]!='1' :
            ans.append((n,n-1))
            cnt+=1
        else:
            ans.append((n-1,n))
            cnt+=1
    print(cnt)
    for i in ans:
        print(i[0],i[1])


for _ in range(int(input())):
    n=int(input())
    solve(n)

