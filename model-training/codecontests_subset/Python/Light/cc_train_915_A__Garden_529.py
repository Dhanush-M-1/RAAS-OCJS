n,m= input().split()
L=input().split()
L=[int(x) for x in L]
m=int(m)
n=int(n)
i=int(m)
while(i>0):
    if(m%i==0):
        if i in L:
            print(int(m/i))
            break
    i-=1
    
