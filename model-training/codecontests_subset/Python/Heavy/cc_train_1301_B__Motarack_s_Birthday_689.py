def f(n,A,x):
    B = A[:]
    for i in range(n):
        if B[i] == -1:
            B[i] = x
    m = 0
    for i in range(n-1):
        m = max(abs(B[i]-B[i+1]),m)
    return(m)
t = int(input())
while(t>0):
    t = t-1
    n = int(input())
    a = input()
    A = list(map(int,list(a.split())))
    l = min(A)
    h = max(A)
    while(l<=h):
        mid = (l+h)//2
        if f(n,A,mid)<=f(n,A,mid-1) and f(n,A,mid)<=f(n,A,mid+1):
            if mid<0:
                print(f(n,A,0),end=" ")
                print(0)
            elif mid>(10**(9)):
                prin(f(n,A,10**(9)),end=" ")
                print(10**(9))
            else:
                print(f(n,A,mid),end=" ")
                print(mid)
            break
        elif f(n,A,mid)>f(n,A,mid-1):
            h = mid-1
        elif f(n,A,mid)<f(n,A,mid-1):
            l = mid+1