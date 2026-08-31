from math import gcd
def prime(n):
    a=[]
    for i in range(1,int(n**(1/2))+1):
        #print("I")
        if i==1:
            #print(n,i)
            if n%i==0:
                #print("o")
                if (i*int((n/i)))/gcd(i,int(n/i)) ==n:
                    a.append([1,n/i])
        else:
            if (i*int((n/i)))/gcd(i,int(n/i)) ==n:
                a.append([i,n/i])
    return a
n=int(input())
a=prime(n)
#print(a)
if len(a)==1:
    print(a[0][0],int(a[0][1]))
else:
    print(a[len(a)-1][0],int(a[len(a)-1][1]))
    
    
    
