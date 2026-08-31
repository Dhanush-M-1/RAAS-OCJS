def primeFactors(n):
    a = 0
    b = 0
      
    while n % 2 == 0: 
        n = n // 2
        a += 1

    while n % 3 == 0:
        n = n // 3
        b += 1
          
    if n != 1:
        return -1

    else:
        if a > b:
            return -1
        elif a == b:
            return a
        else:
            return 2 * b - a


import math
def main():
    t = int(input())
    for i in range(t):
        solve()

def solve():
    n = int(input())
    if n == 1:
        print(0)
        return

    print(primeFactors(n))

main()
