from decimal import Decimal
x,y,z = map(Decimal, input().split())
# Base of logarithm should not matter
fs = [
    lambda x,y,z: y**z * x.ln(),
    lambda x,y,z: z**y * x.ln(),
    lambda x,y,z: y*z * x.ln(),
    lambda x,y,z: y*z * x.ln(),

    lambda x,y,z: x**z * y.ln(),
    lambda x,y,z: z**x * y.ln(),
    lambda x,y,z: x*z * y.ln(),
    lambda x,y,z: x*z * y.ln(),

    lambda x,y,z: x**y * z.ln(),
    lambda x,y,z: y**x * z.ln(),
    lambda x,y,z: x*y * z.ln(),
    lambda x,y,z: x*y * z.ln()
]
arr = [
    'x^y^z','x^z^y','(x^y)^z','(x^z)^y',
    'y^x^z','y^z^x','(y^x)^z','(y^z)^x',
    'z^x^y','z^y^x','(z^x)^y','(z^y)^x'
]
res = [f(x,y,z) for f in fs]
print(arr[res.index(max(res))])
