import sys
input = sys.stdin.readline

def solve():
    n=int(input())
    M=[list(input().strip()) for _ in range(n)]
    ans = []
    
    a,b,c,d=M[0][1],M[1][0],M[n-1][n-2],M[n-2][n-1]
    if c==d:
        if a==d:
            ans.append((1,2))
        if b==d:
            ans.append((2,1))
    elif a==b:
        if c==a:
            ans.append((n,n-1))
        if d==a:
            ans.append((n-1,n))
    else:
        if a=='1':
            ans.append((1,2))
        if b=='1':
            ans.append((2,1))
        if c=='0':
            ans.append((n,n-1))
        if d=='0':
            ans.append((n-1,n))
    print(len(ans))
    for i in ans:
        print(*i)




if __name__=="__main__":
    for _ in range(int(input())):
        solve()



