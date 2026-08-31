import math
n = int(input())


def primeFactors(n): 
    ans = []
      
    # Print the number of two's that divide n 
    fac = 1
    while n % 2 == 0: 
        n = n // 2
        fac *= 2

    if fac != 1:
        ans.append(fac)
          
    for i in range(3,int(math.sqrt(n))+1,2): 
        fac = 1
          
        while n % i== 0: 
            n = n // i 
            fac *= i

        if fac != 1:
            ans.append(fac)
              
    if n > 2: 
        ans.append(n)
    return ans

def dfs(prod, ind):
    global ma
    if prod > li:
        return
    ma = max(ma, prod)
    if ind == len(ans):
        return
    dfs(prod * ans[ind], ind + 1)
    dfs(prod, ind + 1)

ans = primeFactors(n)

li = math.floor(math.sqrt(n))

ma = 1
dfs(1, 0)

print(ma, n//ma)


    

