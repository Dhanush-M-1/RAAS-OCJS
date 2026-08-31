a, b = [int(i) for i in input().split()]
C=0
RES=0
while a>0:
    RES+=a
    a, C = (a+C)//b, (a+C)%b
print(RES)


