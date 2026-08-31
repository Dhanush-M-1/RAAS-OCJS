
def f(a,b,c):
    if a==0 and b>c:
        return 0
    elif a==0 and b<=c:
        return f(c//b,b,c%b)
    else:
        return a+f(a//b,b,c+a%b)

x=input().split()
a=int(x[0])
b=int(x[1])
print(f(a,b,0))
