a,b = map(int,input().split())
c = 0
while(a >= b):
    a -= b - 1
    c += b
print(c + a)
