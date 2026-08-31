from collections import Counter
for _ in range(int(input())):
    n=int(input())
    l=[]
    for i in range(n):
        s=input()
        l.append(s)
    a1=int(l[0][1])
    a2=int(l[1][0])
    b1=int(l[n-1][n-2])
    b2=int(l[n-2][n-1])
    x=[a1,a2,b1,b2]
    d=Counter(x)
    if len(set(x))==1:
        print(2)
        print(1,2)
        print(2,1)
    elif len(set([a1,a2]))==1 and len(set([b1,b2]))==1:
        print(0)
    else:
        if len(set([a1,a2]))==2 and len(set([b1,b2]))==1:
            if a1==b1:
                print(1)
                print(1,2)
            elif a2==b1:
                print(1)
                print(2,1)
        elif len(set([a1,a2]))==1 and len(set([b1,b2]))==2:
            if b1==a1:
                print(1)
                print(n,n-1)
            elif b2==a1:
                print(1)
                print(n-1,n)
        elif len(set([a1,a2]))==2 and len(set([b1,b2]))==2:
            if a1==b1:
                print(2)
                print(1,2)
                print(n-1,n)
            else:
                print(2)
                print(1,2)
                print(n,n-1)
        
                
            
        