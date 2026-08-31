import sys
def main():
    input = sys.stdin.readline
    H,W,K=map(int, input().split())
    A=[list(input()) for _ in range(H)]

    from collections import deque
    q=deque()
    for i in range(H):
        for j in range(W):
            if A[i][j]=='S':
                q.append((i,j,0))
                A[i][j]='#'

    ans=10**9
    while q:
        i,j,d = q.popleft()
        if i==0 or i==H-1 or j==0 or j==W-1:
            print(1)
            exit()
        ans = min(ans, (min(i,j,H-1-i,W-1-j) + K-1) // K + 1)
        if d==K: continue
        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj=i+di,j+dj
            if A[ni][nj]!='#':
                q.append((ni,nj,d+1))
                A[ni][nj]='#'
    print(ans)

if __name__ == '__main__':
    main()