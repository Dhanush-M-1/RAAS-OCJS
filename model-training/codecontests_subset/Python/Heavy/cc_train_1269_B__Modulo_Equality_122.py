def find(key,k,m):
    if(m>=k and k>=key):
        n=k-key
    elif(m>=k and k<key):
        n=m-(key-k)
    else:
        return -1
    return n

def convert(a,n,m):
    array=[]
    for i in a:
        array.append((i+n)%m)
    return array

def compare(a,b):
    a.sort()
    b.sort()
    i=0
    while(i<len(a)):
        if(a[i]!=b[i]):
            return False
        i+=1
    return True

n,m=input().split()
n=int(n)
m=int(m)
a=list(map(int,input().split()))
b=list(map(int,input().split()))
hasha=dict()
for i in a:
    if(i in hasha):
        hasha[i]+=1
    else:
        hasha[i]=1
hashb=dict()
for j in b:
    if(j in hashb):
        hashb[j]+=1
    else:
        hashb[j]=1

key=a[0]
minm=2**31-1
for k in hashb:
    if(hasha[key]==hashb[k]):
        n=find(key,k,m)
        if(n!=-1):
            newa=convert(a,n,m)
            if(compare(newa,b)):
                minm=min(n,minm)
print(minm)