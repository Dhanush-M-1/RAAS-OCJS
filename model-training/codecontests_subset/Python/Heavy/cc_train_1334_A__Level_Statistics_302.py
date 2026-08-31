"""T=int(input())
for _ in range(0,T):
    n=int(input())
    a,b=map(int,input().split())
    s=input()
    s=[int(x) for x in input().split()]
    for i in range(0,len(s)):
        a,b=map(int,input().split())"""


T=int(input())
for _ in range(0,T):
    n=int(input())
    L=[]
    p=0
    c=0
    temp='YES'
    for i in range(0,n):
        a,b=map(int,input().split())
        #L.append((a,b))
        if(a<p or b<c):
            temp='NO'
        else:
            diff1=a-p
            diff2=b-c
            if(diff2>diff1):
                temp='NO'
        p=max(p,a)
        c=max(c,b)

    print(temp)
            
