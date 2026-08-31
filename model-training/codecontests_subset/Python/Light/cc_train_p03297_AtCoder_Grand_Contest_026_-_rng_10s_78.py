def gcd(a, b):
    if a < b:
        a,b = b,a
    while b:
        a, b = b, a % b
    return a
T = int(input())
for _ in range(T):
    A,B,C,D = map(int,input().split())
    if A < B or D < B:
        print('No')
    else:
        g = gcd(B,D)
        k = B//g
        r = (A-C)%B
        if r == 0:
            sm = C
        else:
            sm = C+r-B
        if sm < 0:
            print('No')
        else:
            s = sm%g
            if s + (k-1)*g <= C:
                print('Yes')
            else:
                print('No')