def prime_factors(n):
    i = 2
    factors = []
    while i * i <= n:
        if n % i:
            i += 1
        else:
            n //= i
            factors.append(i)
    if n > 1:
        factors.append(n)
    return factors

N,p=map(int, input().split(" "))
tmp=prime_factors(p)

d={}
count=1
#result=[]
if N==1:
    print(p)
else:
    for i in tmp:
        if i in d:
            if d[i]==N-1:
                d[i]=0
                #result.append(i)
                count*=i
            else:
                d[i]+=1
        else:
            d[i]=1
    print(count)
