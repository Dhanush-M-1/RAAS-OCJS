def f(n):
    i = 6
    c = 1
    while(i<=n):
        if i == n:
            return(c)
        else:
            i = i*6
            c = c+1
    return(-1)
def g(n):
    i = 2
    c = 0
    while(n%2 == 0):
        n = n//2
        c = c+1
    d = 0
    while(n%3 == 0):
        n = n//3
        d = d+1
    if n != 1:
        return(-1)
    else:
        return([d,c])
t = int(input())
while(t>0):
    t = t-1
    n= int(input())
    if n == 1:
        print(0)
    elif f(n) != -1:
        print(f(n))
    elif g(n) == -1:
        print(-1)
    else:
        ls = g(n)
        if ls[0]<ls[1]:
            print(-1)
        else:
            ans = ls[0]+(ls[0]-ls[1])
            print(ans)
        
        