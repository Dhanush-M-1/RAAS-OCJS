import sys
input = sys.stdin.readline

'''

'''

def prime_factorize(n):
    count = {3:0, 2:0}

    for p in [2, 3]:
        while n % p == 0:
            count[p] += 1
            n //= p
    
    flag = True if n == 1 else False
    return flag, count


def solve(n):
    """
    multiply by 2 or divide by 6
    """
    flag, count = prime_factorize(n)
    if not flag:
        return -1
    else:
        if count[3] >= count[2]:
            return count[3] + (count[3] - count[2])
        else:
            return -1

t = int(input())
for _ in range(t):
    n = int(input())
    print(solve(n))