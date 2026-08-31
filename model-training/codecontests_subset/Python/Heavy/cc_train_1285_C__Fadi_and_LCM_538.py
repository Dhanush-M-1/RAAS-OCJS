import math

def gcd(a,b):
    if a == 0 :
        return b
    return gcd(b%a,a)

def lcm(a,b):
    return (a*b)/gcd(a,b)

x = int(input())
ans = 9999999999999
ansa = 0
ansb = 0
a = False
if x == 1:
    print("1 1")
    a = True

if a == False:
    for i in range(1,int(math.sqrt(x))+1):
        if(x%i == 0):
            if(i == x/i):
                continue
            else :
                a = i
                b = x/i
                if(lcm(a,b) == x):
                    if(max(a,b) < ans):
                        ans = max(a,b)
                        ansa = a
                        ansb = b



    print(int(ansa),int(ansb))
