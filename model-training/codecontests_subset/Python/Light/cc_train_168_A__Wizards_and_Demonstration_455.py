import decimal
D = decimal.Decimal

l1 = [int(x) for x in input().split()]
n,x,y = l1[0],l1[1],l1[2]
need = n*y
have = x*100
extra = 0
i=0
while need-have>extra:
    extra+=100
    i+=1
print(i)