a, b = [int(s) for s in input().split()]

burned = 0
r = 0
while a>0:
    burned += a
    if r>0 :
        a += r
    a, r= a//b, a%b
print(burned)
