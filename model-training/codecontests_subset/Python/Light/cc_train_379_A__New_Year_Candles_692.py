a,b = map(int,input().split())
c = a
cout = 0
while a>=b:
    cout += a//b
    a = a//b + a%b
print(c+cout)
