"""
T=int(input())
for _ in range(0,T):
    N=int(input())
    s=input()
    a,b=map(int,input().split())
    s=[int(x) for x in input().split()]

"""

T=int(input())
for _ in range(0,T):
    n=int(input())
    s=[int(x) for x in input().split()]

    t1=0
    t2=0
    t3=0


    mx=s[0]
    for i in range(1,len(s)):
        mx=min(s[i],mx-1)

    if(mx>-1):
        t1=1

    mx=s[-1]
    for i in range(len(s)-2,-1,-1):
        mx=min(s[i],mx-1)

    if(mx>-1):
        t2=1


    temp=0
    c=1
    for i in range(1,len(s)):
        if(c==1):
            if(s[i]>=temp+1):
                temp+=1
            else:
                temp=s[i-1]
                temp=min(s[i],temp-1)
                c=2

        else:
            temp=min(s[i],temp-1)


    if(temp>=0):
        t3=1
    #print(t1,t2,t3)
    if(t1==1 or t2==1 or t3==1):
        print('Yes')
    else:
        print('No')
        

    
