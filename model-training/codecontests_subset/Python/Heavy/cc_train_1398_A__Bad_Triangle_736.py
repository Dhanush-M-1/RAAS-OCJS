def sieve():
    n=10**5
    s=[[] for i in range(n+1)]
    for i in range(2,n+1,2):
        s[i]=[2]
    for i in range(3,n+1,2):
        if(s[i]):
            continue
        else:
            for j in range(i,n+1,i):
                s[j].append(i)
    return s
def prime():
    n=10**5
    s=[1 for i in range(n+1)]
    for i in range(2,n+1):
        if(s[i]==1):
            for j in range(i*i,i<n+1,i):
                s[j]=0
    primes=[]
    for i in range(2,n+1):
        if(s[i]==1):
            primes.append(i)
    return primes


for cases in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    a=l[0]
    b=l[1]
    c=l[-1]
    if(c<a+b):
        print(-1)
    else:
        print(1,2,len(l))

    
