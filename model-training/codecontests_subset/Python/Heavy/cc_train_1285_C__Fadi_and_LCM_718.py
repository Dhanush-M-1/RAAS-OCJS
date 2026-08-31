import math
# This function computes GCD 
def compute_gcd(x, y):

   while(y):
       x, y = y, x % y
   return x

# This function computes LCM
def compute_lcm(x, y):
   lcm = (x*y)//compute_gcd(x,y)
   return lcm

def getFactors(n):
    if n == 1:
        return [1, 1]
    factors = []
    i = 1
    while i <= math.sqrt(n): 
        if (n % i == 0 and n // i != i): 
            factors.append(i)
            factors.append(n//i)
        i = i + 1
    return sorted(factors)

def solve():
    n = int(input())

    arr = getFactors(n)
    l = len(arr) // 2 - 1
    r = len(arr) // 2

    while l >= 0:
        if compute_lcm(arr[l], arr[r]) == n:
            print(arr[l], arr[r])
            return

        l -= 1
        r += 1

solve()