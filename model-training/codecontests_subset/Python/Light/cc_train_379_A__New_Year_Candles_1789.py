a,b=map(int,input().split())
def f(a,b):
    x=a
    while a>=b:
        x=x+a//b
        a=(a//b)+(a%b)
    return x
print(f(a,b))