from math import log
from decimal import Decimal


asd=["x^y^z","x^z^y","(x^y)^z","(x^z)^y","y^x^z","y^z^x","(y^x)^z","(y^z)^x","z^x^y","z^y^x","(z^x)^y","(z^y)^x"]
ans=[]

x,y,z=map(Decimal,input().split())

def pow2(a,b):
    return a**b

ans.append(x.ln()*pow2(y,z))
ans.append(x.ln()*pow2(z,y))
ans.append(x.ln()*y*z)
ans.append(x.ln()*y*z)
ans.append(y.ln()*pow2(x,z))
ans.append(y.ln()*pow2(z,x))
ans.append(y.ln()*x*z)
ans.append(y.ln()*x*z)
ans.append(z.ln()*pow2(x,y))
ans.append(z.ln()*pow2(y,x))
ans.append(z.ln()*y*x)
ans.append(z.ln()*y*x)

anss=-10000000000000000000000000000

for i in range(12):
    if(ans[i]>anss):
        anss=ans[i]

for i in range(12):
    if(ans[i]==anss):
        print(asd[i])
        exit()

        
