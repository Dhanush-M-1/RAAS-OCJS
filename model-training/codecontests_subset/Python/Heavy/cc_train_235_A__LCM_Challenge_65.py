#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
#  code
from math import gcd
if __name__ == "__main__":
    n = int(input())
    if n == 1:
        print(1)
    elif n == 2:
        print(2)
    elif n == 3:
        print(6)
    elif n == 4:
        print(12)

    elif n%2 == 1:
        print(n*(n-1)*(n-2))
    else:
        ans = (n-2) * (n-1) * (n-3)
        j = n - 3
        while j >= 1:
            if gcd(j,n) > 1:
                break
            ans = max(n*(n-1)*j , ans)
            j -= 2
        print(ans)

    