n=int(input())
k=int(input())
def k1(n):
    n_l=len(str(n))
    n_0=int(str(n)[0])
    return n_0+9*(n_l-1)
def k2(n):
    n_l=len(str(n))
    if n_l<=1:
        return 0
    n_0=int(str(n)[0])
    return 81*((n_l-1)*(n_l-2)//2)+(n_0-1)*9*(n_l-1)+k1(n%(10**(n_l-1)))
def k3(n):
    n_l=len(str(n))
    if n_l<=2:
        return 0
    n_0=int(str(n)[0])
    return 729*((n_l-1)*(n_l-2)*(n_l-3)//6)+(n_0-1)*81*((n_l-1)*(n_l-2)//2)+k2(n%(10**(n_l-1)))
if k==1:
    print(k1(n))
if k==2:
    print(k2(n))
if k==3:
    print(k3(n))