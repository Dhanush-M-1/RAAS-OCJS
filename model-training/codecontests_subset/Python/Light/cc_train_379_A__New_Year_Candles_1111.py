a, b = map(int, input().split())

z = 0
out = 0
while a!=0:
    out+=a
    z, a = (a+z)%b, (a+z)//b

print(out)
    
    
