from math import ceil,floor
t=int(input())
import bisect
while t:

    n=int(input())
    l=list(map(int,input().split()))
    ll=set()
    ans=0
    for i in range(n):
        if(l[i]==-1):
            if(i+1<n and l[i+1]!=-1):
                ll.add(l[i+1])
            if(i-1>=0 and l[i-1]!=-1):
                ll.add(l[i-1])
        else:
            if(i+1<n and l[i+1]!=-1):
                ans=max(ans,abs(l[i]-l[i+1]))
            if(i-1>=0 and l[i-1]!=-1):
                ans=max(ans,abs(l[i]-l[i-1]))
            
    ll=list(ll)
    ll.sort()
    n=len(ll)
    #print(ll)
    if(n):
        su=min(ll)+max(ll)
        ans1=ans
        ans2=ans
        su1=ceil(su/2)
        su2=floor(su/2)
        for i in ll:
            ans1=max(ans1,abs(i-su1))
            ans2=max(ans2,abs(i-su2))
        #print
        if(ans1<ans2):
            print(ans1,su1)
        else:
            print(ans2,su2)
    else:
        print(0,0)
           
    '''
    
    ans1=ans
    ans2=ans
    ans3=ans
    #print(ll)
    if(n%2):
        x=ll[n//2]
        for i in ll:
            ans=max(ans,abs(i-x))
        print(ans,ll[n//2])
    elif(n%2==0 and n):
        x=(ll[n//2]+ll[n//2-1])
        if(x%2):
            x1=x//2
            x2=(x+1)//2
            x3=(x-1)//2
            #print(x1,x2,x3)
            for i in ll:
                ans1=max(ans1,abs(i-x1))
                ans2=max(ans2,abs(i-x2))
                ans3=max(ans3,abs(i-x3))
            mans=min(ans1,ans2,ans3)
            if(mans==ans1):
                x=x1
            elif(mans==ans2):
                x=x2
            else:
                x=x3
            ans=mans
        else:
            x=x//2
            for i in ll:
                ans=max(ans,abs(i-x))
        print(ans,x)
        #print(ans,ll[n//2])
    else:
        print(0,0)
    
    pre=[ll[0]]
    for i in range(1,n):
        pre.append(ll[i]+pre[-1])
    pos=[0]*n
    pos[-1]=ll[-1]
    for i in range(n-2,-1,-1):
        pos[i]=ll[i]+pos[i+1]
    le=ll[0]-1
    re=ll[-1]+1
    mi=sum(ll)
    while re-le>1:
        mid=(le+re)//2
        ind=bisect.bisect_right(ll,mid)
        cur=(mid*(ind+1))-pre[ind]+pos[ind]-(mid*(n-ind-1))
        if(cur<mi):
    
    '''
    t-=1  
                                