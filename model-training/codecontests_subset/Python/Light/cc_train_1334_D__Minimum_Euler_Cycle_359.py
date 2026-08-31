R = lambda:map(int, input().split())
 
t = int(input())

def block(b, pos, n):
    if pos%2 == 0: return b
    return b + (pos+1)//2


def binary(k, n):
    left, right = 1, n+1
    while left <= right:
        m = (left + right)//2
        if m*(m+1) >= k > m*(m-1): return m
        if m*(m+1) < k: left = m + 1
        if m*(m-1) >= k: right = m - 1
        
        
def whatis(k, n):
    k = n*(n-1) + 1 - k
    if k == 0: return 1
    i =  binary(k, n)
    return block(n - i, - k + i*(i+1), n)




for _ in range(t):
    n, l, r = R()
    ans = []
    for i in range(l, r+1):
        ans.append(whatis(i, n))
    print(*ans)