t=int(input())
for i in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    z=n//2
    a=[]
    for i in range(z):
        if l[i]!=l[z]:
            a.append(l[i])
    if len(set(a))<3:
        print(0,0,0)
    else:
        x=len(a)
        g=1
        s=0
        b=1
        m=a[0]
        n=a[x-1]
        reserved=[]
        for i in range(1,x-1):
            if a[i]==m:
                g+=1
            elif a[i]==n:
                b+=1
            else:
                s+=1 
                reserved.append(a[i])
        if g<s and g<b:
            print(g,s,b)
        else:
            if len(set(reserved))==1 or (g>=s and g>=b) or (g>=s+b):
                print(0,0,0)
            else:
                reserved.reverse()
                k=[]
                c=0
                for i in range(1,len(reserved)):
                    if(reserved[i]>reserved[i-1]):
                        k.append(i-c)
                        c=i
                for i in range(len(k)):
                    if b<=g:
                        b+=k[i]
                        s-=k[i]
                if g<s and g<b:
                    print(g,s,b)        
                else:
                    print(0,0,0)
        
        
        