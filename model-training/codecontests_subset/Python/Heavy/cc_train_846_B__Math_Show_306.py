##a = list(map(int, input().split()))
##print(' '.join(map(str, res)))

[n, k, M] = list(map(int, input().split()))
t = list(map(int, input().split()))
t.sort()
tot = sum(t)

res = 0
for x in range(n+1):
    need = x*tot    
    if need <= M:
        cnt = x*(k+1)
        r = M-need
        j = 0
        while r > 0 and j < k:
            if t[j]*(n-x) <= r:
                cnt += n-x
                r -= t[j]*(n-x)
                j += 1
            else:
                cnt += r//t[j]
                r -= (r//t[j])*t[j]
                break
        res = max(res, cnt)
print(res)

        
