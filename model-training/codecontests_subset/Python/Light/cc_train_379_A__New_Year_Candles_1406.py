def s(a,b):
    h=a
    while a>=b:
        h+=(a//b)
        a=(a//b)+(a%b)
    return h
a,b=map(int,input().split())
print(s(a,b))