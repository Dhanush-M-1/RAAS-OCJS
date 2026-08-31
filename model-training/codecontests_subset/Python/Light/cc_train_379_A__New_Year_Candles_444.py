ab = input().split()
a = int(ab[0])
b = int(ab[1])
c=a
while(a>=b):
    c += a//b
    div = a//b
    rem = a%b
    a = div+rem
print(c)