def solve():
    n = int(input())
    if n == 1:
        print(1,1)
        return
    
    x = n
    factors = []
    i = 2
    while i*i <= n:
        if n % i == 0:
            cur = 1
            while n % i == 0:
                n //= i
                cur *= i
            factors.append(cur)
        i += 1
    if n > 1:
        factors.append(n)
    
    n = len(factors)
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
            curr = factors[k]
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
