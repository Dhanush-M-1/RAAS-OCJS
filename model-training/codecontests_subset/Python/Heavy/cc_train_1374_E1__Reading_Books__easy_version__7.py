from sys import stdin
input=stdin.readline

def answer():
    if(n3+n1 < k or n3+n2 < k):return -1

    i,j=0,0

    ans=0
    for take in range(k):

        if(i >= n1 or i >= n2):
            ans+=common[j]
            j+=1

        elif(j >= n3):
            ans+=a[i]+b[i]
            i+=1

        else:
            if(a[i]+b[i] > common[j]):
                ans+=common[j]
                j+=1
            else:
                ans+=a[i]+b[i]
                i+=1

    return  ans
        
     
n,k=map(int,input().split())

a,b,common=[],[],[]
for i in range(n):
    t,x,y=map(int,input().split())
    
    if(x and y):common.append(t)
    elif(x==1 and y==0):a.append(t)
    elif(x==0 and y==1):b.append(t)

common.sort()
a.sort()
b.sort()

n1,n2,n3=len(a),len(b),len(common)

print(answer())
