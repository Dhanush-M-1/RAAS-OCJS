import fractions
T = int(input())

L = []
for i in range(0,T):
    L = list(map(int, input().split()))
    A = L[0]
    B = L[1]
    C = L[2]
    D = L[3]

    ans = "Yes"
    if A < B: #前提条件
        ans = "No"
    elif D < B: #前提条件
        ans = "No"
    elif B - C <= 1: #BとCの差が1より小さければ何が来てもOK
        ans = "Yes"
    elif C < B-fractions.gcd(B,D)+(A%fractions.gcd(B,D)):
        ans = "No"


    print(ans)
    L = []

