import sys

cases = False

# Pre-defined function
# Begin
def c2(n):
    return n * (n-1) // 2

def get():
    return list(map(int, input().split()))

def bits(n: int):
    return list(bin(n)).count('1')

def main(test_case = False):
    n = int(input()) if test_case else 1
    for _ in range(n):
        test()

def flush():
    sys.stdout.flush()

def parr(arr):
    print(*arr, sep=' ')

def gcd(a, b):
    while b:
        if b % a == 0:
            break
        tmp = a
        a = b % a
        b = tmp
    return a
# End

def ext_gcd(a: int, b: int):
    if (b == 0):
        return [a, [1, 0]]
 
    res = ext_gcd(b, a % b)
    g = res[0]
    x1 = res[1][0]
    y1 = res[1][1]
    x = y1
    y = x1 - y1 * (a // b)
 
    return [g, [x, y]]

def test():
    n = int(input())
    a = get()

    if n == 1:
        print(1, 1)
        print(0)
        print(1, 1)
        print(0)
        print(1, 1)
        print(-a[0])
        return

    print(1, 1)
    print(-a[0])
    a[0] = 0

    k = ext_gcd(n, n-1)
    print(2, n)
    for i in range(n-1):
        temp = -k[1][1] * a[i+1] * (n-1)
        a[i+1] += temp
        print(temp, end=' ')
    print('')
    
    print(1, n)
    for i in range(n):
        print(-a[i], ' ')

main(cases)