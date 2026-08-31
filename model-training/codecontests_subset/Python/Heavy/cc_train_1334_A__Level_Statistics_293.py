n=int(input())
for i in range(n):
    a=int(input())
    P=[]
    C=[]
    for j in range(a):
        p,c=map(int,input().split())
        P.append(p)
        C.append(c)
    z=0
    for k in range(a):
        if(z==0):
            if(C[k]>P[k]):
                print("NO")
                z=1
    for k in range(1,a):
        if(z==0):
            if(P[k]<P[k-1]):
                print("NO")
                z=1
        if(z==0):
            if(C[k]<C[k-1]):
                print("NO")
                z=1
        if(z==0):
            if(P[k-1]==P[k] and C[k-1] != C[k]):
                print("NO")
                z=1
        if(z==0):
            if((P[k]-P[k-1]) < (C[k]-C[k-1])):
                print("NO")
                z=1
    if(z==0):
        print("YES")
    