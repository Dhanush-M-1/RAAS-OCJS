T = int(input().strip())

for t in range(T):
    n, l, r = map(int, input().strip().split())
    if l == n*(n-1)+1:
        print(1)
        continue
    k = int((2*n-1-((2*n-1)**2-4*l)**0.5)/2)
    if l <= 2*k*n- k*(k+1): k -= 1
    if l > 2*(k+1)*n - (k+1)*(k+2): k += 1
    m = 2*k*n - k*(k+1)
    s = []
    k += 1
    j = (l-m-1)//2 + k
    while l<=r:
        if l%2 == 1:
            if k==n: s.append(1)
            else: s.append(k)
        else:
            j += 1
            s.append(j)
            if j == n:
                k += 1
                j = k
        l += 1
        
    print(" ".join(map(str, s)))
        