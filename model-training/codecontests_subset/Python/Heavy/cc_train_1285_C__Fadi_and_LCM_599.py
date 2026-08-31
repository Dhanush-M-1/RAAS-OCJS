def LCM(a,b,x):
    hcf=HCF(a,b)
    lcm=a*b//hcf
    if int(lcm)==x:
        return True
    else:
        return False

def HCF(a,b):
    x=max(a,b)
    y=min(a,b)
    if x%y==0:
        return y
    else:
        return HCF(y,x%y)

x=int(input())
factors_Array=[]
factors_Array.append(1)
factors_Array.append(x)
if x**0.5!=int(x**0.5):
    for i in range(2,int(x**0.5)+1):
        if x%i==0:
            factors_Array.append(i)
            factors_Array.append(x//i)
elif x**0.5==int(x**0.5):
    for i in range(2,int(x**0.5)):
        if x%i==0:
            factors_Array.append(i)
            factors_Array.append(x//i)
    
if x**0.5==int(x**0.5):
    factors_Array.append(int(x**0.5))

factors_Array.sort()
# print(factors_Array)
pairs=[]
n=len(factors_Array)
for i in range(len(factors_Array)//2):
    a=factors_Array[i]
    b=factors_Array[n-i-1]
    if LCM(a,b,x):
        pairs.append([a,b])

# print(pairs)
ans=max(pairs)
for i in range(2):
    print(ans[i],end=" ")



    
