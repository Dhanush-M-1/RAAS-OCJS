a,b =[int(x) for x in input().split()]
printre = 0
c= 0
while a!=0:
    printre +=a
    c += a%b
    a //= b
    if c>= b:
        a+=1
        c-=b
print(printre)
