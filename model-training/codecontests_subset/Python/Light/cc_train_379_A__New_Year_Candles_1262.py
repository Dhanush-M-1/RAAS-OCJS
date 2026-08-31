a,b = map(int,input().split())
k = a
while a>=b:
    di = a//b
    r  = a%b
    k += di
    a = di+r
print(k)    