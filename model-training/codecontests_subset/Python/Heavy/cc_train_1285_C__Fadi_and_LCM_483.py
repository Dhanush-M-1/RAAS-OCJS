import math
def coprime(a,b):
    ok = True
    if(b%a==0):
        ok = False
    else:
        for i in range(2, int(math.sqrt(a))+1):
            if(b%i==0):
                ok = False
                break
    return ok

def facts(n):
    ans = []
    for i in range(1, int(math.sqrt(n)+1)):
        if(n%i==0):
            ans.append(i)
            ans.append(n//i)
    ans = sorted(ans)
    return ans
x = int(input())
fs = facts(x)
pnt1, pnt2 =(len(fs)//2)-1, (len(fs)//2)
a,b = 0, 0
while(pnt1> 0):
    if(math.gcd(fs[pnt1], fs[pnt2])==1):
        a, b = fs[pnt1], fs[pnt2]
        break
    pnt1-=1
    pnt2+=1
if(a==0 and b==0):
    print(1, x)
else:
    print(a,b)