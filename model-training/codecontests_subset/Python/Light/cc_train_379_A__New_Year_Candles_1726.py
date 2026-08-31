a,b = map(int,input().split())
j = a + a//b
a = a//b + (a%b)
while a >= b:
    j += a//b
    a = (a//b + (a%b))
print(j)
