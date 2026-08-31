'''
3
4
S010
0001
1000
111F
3
S10
101
01F
5
S0101
00000
01111
11111
0001F
'''

n=int(input())
for i in range(0,n):
    o=int(input())
    N=0;
    A=0
    L=[]
    B=0
    C=0
    D=0
    for j in range(0,o):
        s=input().rstrip()
        x=list(s)
        if j==0:
            A=int(x[1])
        if j==1:
            B=int(x[0])
        if j==o-2:
            C=int(x[len(x)-1])
        if j==o-1:
            D=int(x[len(x)-2])
   # print(A,B,C,D)
    if A==B:
        ans = 0;
        if A==0:
            if C!=1:
                ans+=1;
                L.append(o-1)
                L.append(o)
            if D!=1:
                ans+=1;
                L.append(o)
                L.append(o-1)
            #print(L)
        else:
            if C!=0:
                ans+=1;
                L.append(o-1)
                L.append(o)
            if D!=0:
                ans+=1;
                L.append(o)
                L.append(o-1)            
    elif C==D:
        ans = 0;
        if C==0:
            if A!=1:
                ans+=1;
                L.append(1)
                L.append(2)
            if B!=1:
                ans+=1;
                L.append(2)
                L.append(1)
        else:
            if A!=0:
                ans+=1;
                L.append(1)
                L.append(2)
            if B!=0:
                ans+=1;
                L.append(2)
                L.append(1)
    else:
        ans = 0;
        if A==0:
            ans+=1;
            L.append(1)
            L.append(2)
            if C==1:
                ans+=1;
                L.append(o-1)
                L.append(o)
            else:
                ans+=1;
                L.append(o)
                L.append(o-1)
        else:
            ans+=1;
            L.append(1)
            L.append(2)
            if C==0:
                ans+=1;
                L.append(o-1)
                L.append(o)
            else:
                ans+=1;
                L.append(o)
                L.append(o-1)        
    print(ans)
    for j in range(0,len(L),2):
        print(L[j],L[j+1])