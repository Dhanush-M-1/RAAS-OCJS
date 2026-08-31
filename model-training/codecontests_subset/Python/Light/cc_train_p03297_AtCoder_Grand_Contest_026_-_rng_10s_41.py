def gcd( a, b):
    if b == 0:
        return a
    else:
        return gcd( b, a % b)

n = int(input())
list = [map(int, input().split()) for i in range(n)]
 
def check(num):
    a, b, c, d = list[num]
    if a < b:
        return False
    if a % b > c:
        return False
    if b > d:
        return False
    if c < b and d != b:
        if (b - ( a % b ) - 1) // gcd( b, d) != ((c - ( a % b ))) // gcd( b, d):
            return False
    return True
 
for i in range(n):
    if check(i):
        print('Yes')
    else:
        print('No')