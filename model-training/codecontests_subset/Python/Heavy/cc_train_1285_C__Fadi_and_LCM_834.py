def solve():
    n = int(input())
    if n == 1:
        print(1,1)
        return
    
    x = n
    factors = []
    i = 2
    while i*i <= n:
        while n % i == 0:
            factors.append(i)
            n //= i
        i += 1
    if n > 1:
        factors.append(n)
    
    distFactors = []
    currFactor = factors[0]
    prod = 1
    for f in factors:
        if f == currFactor:
            prod *= f
        else:
            distFactors.append(prod)
            currFactor = f
            prod = f
    distFactors.append(prod)
    
    n = len(distFactors)
    ans = [x,1]
    a = [1,1]
    def backtrack(a,k):
        # check if the current configuration is a solution and process it.
        if k == n:
    #        print(a,ans)
            if max(a) < max(ans):
                ans[0] = a[0]
                ans[1] = a[1]
    #            print('ans: ', ans)
        else:
        # Extend the current partial solution to find a valid solution
            curr = distFactors[k]
            k += 1
            a[0] *= curr
            backtrack(a,k)
            a[0] //= curr
            a[1] *= curr
            backtrack(a,k)
            a[1] //= curr
        return
    backtrack(a,0)
    
    print(ans[0], ans[1])
    
solve()
