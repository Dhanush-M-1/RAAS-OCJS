a, b = map(int, input().split())

maxi = a

while a >= b:
    maxi += a//b
    a -= (a//b)*(b-1)
    
print(maxi)