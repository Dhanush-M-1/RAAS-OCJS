def gcd(a,b): 
	if a == 0: 
		return b 
	return gcd(b % a, a)  
def lcm(a,b):
    return a*b//gcd(a,b)
n=int(input())
fact=[]
for i in range(1,int(n**0.5)+2):
    if(n%i==0):
        if(i**2==n):
            fact.append(i)
        else:
            fact.append(i)
            fact.append(n//i)
fact.sort() 
if n==1:
    print("1 1")
elif len(fact)%2==0:
    i=len(fact)//2-1
    j=len(fact)//2
    while(True):
        if lcm(fact[i],fact[j])==n:
            print(fact[i],fact[j])
            break
        else:
            i-=1
            j+=1
else:
    i=len(fact)//2-1
    j=len(fact)//2+1
    while(True):
        if lcm(fact[i],fact[j])==n:
            print(fact[i],fact[j])
            break
        else:
            i-=1
            j+=1