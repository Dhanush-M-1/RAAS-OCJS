import math
def rec(l,l_,s,e,cnt):
        if(s>e):
            return
        elif(s==e):
            l_[s]=cnt
            return
        else:
            maxm=l[s]
            ind=s
            for j in range(s+1,e+1,1):
                if(l[j]>maxm):
                    maxm=l[j]
                    ind=j
            l_[ind]=cnt
            rec(l,l_,s,ind-1,cnt+1)
            rec(l,l_,ind+1,e,cnt+1)
t=int(input())
for i in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    l_=[0]*n
    rec(l,l_,0,n-1,0)
    s=""
    for elem in l_:
        s+=str(elem)+" "
    print(s[:-1])