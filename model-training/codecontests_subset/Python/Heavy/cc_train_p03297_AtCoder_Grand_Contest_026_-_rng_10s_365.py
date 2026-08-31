def gcd(X0,X1):
    Y0=max([X0,X1])
    Y1=min([X0,X1])
    if Y0%Y1==0:
        return Y1
    else:
        return gcd(Y1,Y0%Y1)

def canbuy(A,B,C,D):
    if B>A:
        return False
    elif B>D:
        return False
    elif C>=B:
        return True
    else:
        g=gcd(B,D)
        X=B-g+(A%g)
        if X>C:
            return False
        else:
            return True

T=int(input())
S=["" for i in range(T)]
for i in range(T):
    a,b,c,d=map(int,input().split())
    if canbuy(a,b,c,d):
        S[i]="Yes"
    else:
        S[i]="No"

for i in range(T):
    print(S[i])
