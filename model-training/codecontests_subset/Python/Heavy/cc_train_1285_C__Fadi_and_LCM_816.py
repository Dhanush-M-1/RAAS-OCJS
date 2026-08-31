def gcd(a, b):
    if a == 0:
        return b
    return gcd(b % a, a)
def lcm(a, b):
    return (a * b) / gcd(a, b)


x=int(input())
a=[]
b=[]
rootx= int(x**(0.5))
for i in range(1,rootx+1):
    if x%i==0:
        sec=int(x/i)
        if i==1:
            a.append(i)
            b.append(x)
        else:
            if lcm(sec,i)==x:
                a.append(i)
                b.append(sec)
            # elif sec>i and (i%sec)!=0:
            else:
                continue
    else:
        continue

ans = str(a[-1]) +" " + str(b[-1])
print(ans)

