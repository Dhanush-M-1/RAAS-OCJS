import decimal
decimal.getcontext().prec=300
x,y,z=input().split()
eps=decimal.Decimal(1)
eps/=(10**200)
def tr(x):
    a,b=x.split('.')
    a=int(a)
    b=int(b)
    a=decimal.Decimal(a)
    b=decimal.Decimal(b)
    b/=10
    return a+b
x=tr(x)
y=tr(y)
z=tr(z)
def f(x,y,z):
    return (y**z)*x.ln()
def g(x,y,z):
    return y*z*x.ln()
def chf(ans,x,y,z):
    if abs(ans)<eps:return f(x,y,z)>-eps
    return abs(ans-f(x,y,z))/abs(ans)<eps
def chg(ans,x,y,z):
    if(abs(ans)<eps):return g(x,y,z)>-eps
    return abs(ans-g(x,y,z))/abs(ans)<eps
ans=decimal.Decimal(0)
ans=max(f(x,y,z),f(x,z,y),f(y,x,z),f(y,z,x),f(z,x,y),f(z,y,x))
ans=max(ans,g(x,y,z),g(x,z,y),g(y,x,z),g(y,z,x),g(z,x,y),g(z,y,x))
if chf(ans,x,y,z):
    print('x^y^z')
elif chf(ans,x,z,y):print('x^z^y')
elif chf(ans,y,x,z):print('y^x^z')
elif chf(ans,y,z,x):print('y^z^x')
elif chf(ans,z,x,y):print('z^x^y')
elif chf(ans,z,y,x):print('z^y^x')
elif chg(ans,x,y,z):print('(x^y)^z')
elif chg(ans,x,z,y):print('(x^z)^y')
elif chg(ans,y,x,z):print('(y^x)^z')
elif chg(ans,y,z,x):print('(y^z)^x')
elif chg(ans,z,x,y):print('(z^x)^y')
elif chg(ans,z,y,x):print('(z^y)^x')