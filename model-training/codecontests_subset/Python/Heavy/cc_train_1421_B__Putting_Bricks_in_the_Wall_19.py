from math import *
t=int(input())
while t:
    t=t-1
    #a,b=map(int,input().split())
    
    n=int(input())
    #a=list(map(int,input().split()))
    #out=a^b
    #out2=a^b+b^b
    #print(out)
    a=[]
    for i in range(n):
        s=input()
        a.append(s)
    l=[a[0][1],a[1][0],a[n-1][n-2],a[n-2][n-1]]
    oc=l.count('1')
    zc=l.count('0')
    out=[]
    if oc==4 or zc==4:
        out.append([1,0])
        out.append([0,1])
    elif oc>zc:
        if a[1][0]=='1' and a[0][1]=='0':
            out.append([1,0])
        elif a[1][0]=='0' and a[0][1]=='1':
            out.append([0,1])
        elif a[n-1][n-2]=='1' and a[n-2][n-1]=='0':
            out.append([n-1,n-2])
        elif a[n-1][n-2]=='0' and a[n-2][n-1]=='1':
            out.append([n-2,n-1])
    elif oc<zc:
        if a[1][0]=='0' and a[0][1]=='1':
            out.append([1,0])
        elif a[1][0]=='1' and a[0][1]=='0':
            out.append([0,1])
        elif a[n-1][n-2]=='0' and a[n-2][n-1]=='1':
            out.append([n-1,n-2])
        elif a[n-1][n-2]=='1' and a[n-2][n-1]=='0':
            out.append([n-2,n-1])
    else:
        if a[1][0]!=a[0][1]:
            if a[1][0]=='0':
                out.append([1,0])
            if a[0][1]=='0':
                out.append([0,1])
            if a[n-1][n-2]=='1':
                out.append([n-1,n-2])
            if a[n-2][n-1]=='1':
                out.append([n-2,n-1])
            
    print(len(out))
    for i in out:
        print(i[0]+1,i[1]+1)
    
        







            
    
