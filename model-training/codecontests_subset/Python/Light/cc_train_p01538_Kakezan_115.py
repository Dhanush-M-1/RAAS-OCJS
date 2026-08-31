import math
for _ in range(int(input())):
    n=int(input())
    c=0
    while n>9:
        c+=1
        n=max((n//(10**x))*(n%(10**x)) for x in range(1,int(math.log10(n))+1))
    print(c)