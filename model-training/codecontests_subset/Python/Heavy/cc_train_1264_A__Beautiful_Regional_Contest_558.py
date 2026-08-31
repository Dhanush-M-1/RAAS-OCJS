t=int(input())
for you in range(t):
    n=int(input())
    l=input().split()
    li=[int(i) for i in l]
    g=0
    s=0
    b=0
    i=0
    while(li[i]==li[0]):
        i+=1
        g+=1
        if(i==n):
            break
    if(g<n):
        i=g
        k=g
        while(li[i]==li[k] or s<=g):
            if(li[i]!=li[k]):
                k=i
            s+=1
            i+=1 
            if(i==n):
                break

    if(g+s<n//2):
        b=n//2-g-s
        while(li[g+s+b]==li[g+s+b-1]):
            b-=1
            if(b==0):
                break
    if(b==0 or g+s>=n//2 or b<=g):
        print(0,0,0)
    else:
        print(g,s,b)