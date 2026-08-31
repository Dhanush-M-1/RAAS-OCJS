import sys
readline = sys.stdin.readline

def overlap(a, b, c, d):
    if b <= c or d <= a:
        return False
    return True

T = int(readline())
Ans = [None]*T

for qu in range(T):
    N, l, r = map(int, readline().split())
    l -= 1
    ans = []
    num =[0] + [2*(N-i-1) for i in range(N-1)] + [1]
    for i in range(1, N+1):
        num[i] += num[i-1]
    started = False
    ended = False
    for j in range(N):
        xp = num[j]
        xn = num[j+1]
        if overlap(xp, xn, l, r):
            started = True
        if started:
            cnt = j+2
            for k in range(2*(N-j-1)):
                if xp + k + 1 <= l:
                    if k & 1:
                        cnt += 1
                    continue
                if xp + k + 1 <= r:
                    if k % 2 == 0:
                        ans.append(j+1)
                    else:
                        ans.append(cnt)
                        cnt += 1
                else:
                    ended = True
                    break
        if ended:
            break
                
    if r == N*(N-1)+1:
        ans.append(1)
    Ans[qu] = ' '.join(map(str, ans))
print('\n'.join(map(str, Ans)))