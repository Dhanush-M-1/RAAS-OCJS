primes=[]
primeFactors=[]
factors=[]

def gcd(a, b):
    while (b!=0):
        c=b
        b=a%b
        a=c
    return a

def sieve():
    global primes
    bs=[1]*1000010
    bs[0]=bs[1]=0;
    for i in range(2, 1000001):
        if bs[i]==1:
            for j in range(i*i, 1000001, i):
                bs[j]=0
            primes.append(i)

def p_factorize(N):
    global primes
    global primeFactors
    for p in primes:
        Count=0
        while N%p==0:
            N//=p
            Count+=1
        if Count:
            primeFactors.append((p, Count))
    if N!=1:
        primeFactors.append((N, 1))

def factorize(res, index):
    global primeFactors
    global factors
    prod=1
    if index==len(primeFactors):
        factors.append(res)
        return
    x,y=primeFactors[index]
    for i in range(y+1):
        factorize(res*prod, index+1)
        prod*=x
        
x=int(input())
minim=x
ans1=1
ans2=x
sieve()
p_factorize(x)
factorize(1, 0)
for f in factors:
    if minim>max(f, x//f) and gcd(f, x//f)==1:
        minim=max(f, x//f)
        ans1=f
        ans2=x//f
print (f'{ans1} {ans2}')