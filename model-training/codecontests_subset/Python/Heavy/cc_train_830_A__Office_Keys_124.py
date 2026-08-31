

N , M , P = map(int , input().split(" ") )

A = list(map(int , input().split(" ") ) )

B = list(map(int , input().split(" ") ) )

A = sorted(A)
B = sorted(B)

def check(HAHA):
    vis = [False for _ in range(N)]
    res = 0
    for i in range(M):
        for ii in range(N):
            x = abs(A[ii] - B[i])
            x += abs(P - B[i])
            if vis[ii] == True or x > HAHA:
                continue
            res += 1
            vis[ii] = True
            break
    return res == N

ret = -1
l = 0 ; r = int(3e9)
while l <= r :
    md = (l + r) >> 1
    if check(md):
        ret = md
        r = md - 1
    else :
        l = md + 1

print(ret)