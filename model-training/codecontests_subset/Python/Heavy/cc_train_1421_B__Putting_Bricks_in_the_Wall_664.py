for i1 in range(int(input())):
    n=int(input())
    a=[]
    for i in range(n): 
        a.append(input())
    x=a[0][1]
    y=a[1][0]
    w=a[-1][-2]
    z=a[-2][-1]
    ans=[]
    if(x==y):
        if(w==z):
            if(w!=x):
                pass
            else: 
                ans.append((n,n-1))
                ans.append((n-1,n))
        else:
            if(w==x): ans.append((n,n-1))
            else: ans.append((n-1,n))
    else:

        if(w==z):
            if(w==x): 
                ans.append((1,2))
            else: 
                ans.append((2,1)) 
        else:
            if(x==w):
                ans.append((1,2))
                ans.append((n-1,n))    
            else:
                ans.append((1,2))
                ans.append((n,n-1))
    print(len(ans))
    for l,r in ans: 
        print(l,r)
