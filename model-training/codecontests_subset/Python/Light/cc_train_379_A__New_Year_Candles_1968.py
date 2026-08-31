n,m = map(int,input().split())
nr = n
while n // m > 0:
    notlighted = n % m
    nr += n//m
    n = n//m + notlighted
print(nr)
