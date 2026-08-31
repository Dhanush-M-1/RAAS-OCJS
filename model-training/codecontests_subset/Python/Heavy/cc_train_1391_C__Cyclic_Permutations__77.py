



def InverseofNumber(p):
    naturalNumInverse[0] = naturalNumInverse[1] = 1
    for i in range(2, N + 1):
        naturalNumInverse[i] = (naturalNumInverse[p % i] * (p - int(p / i))  % p)

def InverseofFactorial(p):
    factorialNumInverse[0] = factorialNumInverse[1] = 1
    
    for i in range(2, N + 1):
        factorialNumInverse[i] = (naturalNumInverse[i] *factorialNumInverse[i - 1]) % p
        

def Binomial(N, R, p):
    
    # n C r = n!*inverse(r!)*inverse((n-r)!)
    ans = ((fact[N] * factorialNumInverse[R])% p *factorialNumInverse[N - R])% p
    return ans

def factorial(p):
    fact[0] = 1
    for i in range(1, N + 1):
        fact[i] = (fact[i - 1] * i) % p
        
p = 1000000007
def power(x,y,m=p):  # x**y mod m    
    if (y == 0):
        return 1
    p = power(x, y // 2, m) % m
    p = (p * p) % m
  
    return p if(y % 2 == 0) else  (x * p) % m

N = 1000001
factorialNumInverse = [None] * (N + 1)
naturalNumInverse = [None] * (N + 1) 
fact = [None] * (N + 1)


#InverseofNumber(p)
#InverseofFactorial(p)
factorial(p)


def pro(n):
    print( (fact[n]- pow(2,n-1) )%p)
pro( int( input()) )
