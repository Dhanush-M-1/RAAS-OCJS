a,b = map(int,input().split())
sum = a
while(a>=b):
    div = a//b
    sum += div
    mod = (a%b)
    a = (div+mod)
print(sum)