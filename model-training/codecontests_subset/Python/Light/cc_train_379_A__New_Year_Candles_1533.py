a,b = map(int,input().split())
t = a

while(a>=b):
    h = a//b
    a = a - b*h+h
    t += h
print(t)
