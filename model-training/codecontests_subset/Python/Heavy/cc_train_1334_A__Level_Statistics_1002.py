def solve(ans):
    n=int(input())
    li=[]
    for i in range(n):
        temp=[int(x) for x in input().split()]
        li.append(temp)
    plays,clears=0,0
    for i in range(n):
        if li[i][0]-plays<li[i][1]-clears:
            ans.append('NO')
            break        
        if li[i][0]<li[i][1]:
            ans.append('NO')
            break
        if li[i][0]<plays:
            ans.append('NO')
            break
        if li[i][1]<clears:
            ans.append('NO')
            break
        plays,clears=li[i][0],li[i][1] 
    else:
        ans.append('YES')

t=int(input())
ans=[]
for i in range(t):
    solve(ans)
for ele in ans:
    print(ele)