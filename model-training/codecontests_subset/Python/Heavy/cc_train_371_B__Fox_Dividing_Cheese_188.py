import math
def primeFactors(n):
    D={2:0,3:0,5:0}
    while n % 2 == 0:
        if 2 in D:
            D[2]+=1
        else:
            D[2]=1
        n=n//2
    for i in range(3,int(math.sqrt(n))+1,2):
        while n % i== 0:
            if i in D:
                D[i]+=1
            else:
                D[i]=1
            n=n//i
    if n > 2:
        if n in D:
            D[n]+=1
        else:
            D[n]=1
    return D
lt=list(input().split())
a,b=int(lt[0]),int(lt[1])
if a==b:
    print(0)
else:
    D1=primeFactors(a)
    D2=primeFactors(b)
    a=b=1
    for i in D1:
        if i not in [2,3,5]:
            a*=i**D1[i]
    for i in D2:
        if i not in [2,3,5]:
            b*=i**D2[i]
    if a!=b:
        print(-1)
    else:
        print(abs(D1[2]-D2[2])+abs(D1[3]-D2[3])+abs(D1[5]-D2[5]))
