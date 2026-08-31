n = int(input())
orig = n
factors = [1]
while n%2==0:
    factors[0]*=2
    n//=2
if factors[0]==1:
    factors.pop()
c = 3
while c*c<n:
    if n%c==0:
        factors.append(1)
        while n%c==0:
            factors[-1]*=c
            n//=c
    c+=2
if n>1:
    factors.append(n)
def func(i,cut):
    if i==-1:
        return 1 if cut<=1 else float('inf')
    a1 = func(i-1,cut)
    a2 = func(i-1,cut/factors[i])*factors[i]
    return min(a1,a2)
x = func(len(factors)-1,orig**(1/2))
print(orig//x,x)
