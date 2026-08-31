from math import floor
def gcd(a,b):
    if b == 0:
        return a
    else:
        return gcd(b,a%b)
T = int(input())
for i in range(T):
    A,B,C,D = map(int,input().split())
    if B > D or B > A:
        print("No")
    else:
        if A%B>C:
            print("No")
        else:
            d = gcd(B,D%B)
            r = (A%B)%d
            if B - d + r > C:
                print("No")
            else:
                print("Yes")