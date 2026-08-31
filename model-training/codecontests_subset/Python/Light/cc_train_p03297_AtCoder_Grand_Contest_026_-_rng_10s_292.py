T = int(input())
ABCD = [[int(i) for i in input().split()] for _ in range(T)]

def gcd(a, b) :
    a, b = max(a, b), min(a, b)
    while b != 0 :
        a, b = b, a % b
    return a

def solve(A, B, C, D) :
    if B > A or B > D :
        return 'No'
        
    a0 = A % B
    d = gcd(B, D)
    if a0 + ((C - a0) // d + 1) * d >= B :
        return 'Yes'
        
    return 'No'

for A, B, C, D in ABCD :
    print(solve(A, B, C, D))