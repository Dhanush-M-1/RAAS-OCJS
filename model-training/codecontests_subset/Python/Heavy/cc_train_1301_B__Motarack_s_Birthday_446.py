from sys import stdin
input=stdin.readline
#import bisect
#i = bisect.bisect_left(a, k)
#list=input().split(maxsplit=1)
for xoxo in range(1):
    #a=[]
    for _ in range (int(input())):
        b=[]
        n=int(input()) 
    #ans=[]
    #n,k=map(int, input().split())
        a=[0]+list(map(int, input().split()))
        if a.count(-1)==n:
            print('0 0')
            continue
        a.append(0)
        for i in range(1,n+1):
            if a[i]!=-1:
                if a[i-1]==-1 or a[i+1]==-1:
                        
                    b.append(a[i])
        b=set(b)
        s=sum(b)
        ans1=(max(b)+min(b))//2
        ans=[]
        m1=0
        for j in range(2):
            ans1+=j
            m1=0
            for i in range(2,n+1):
                x,y=a[i],a[i-1]
                if x==-1:
                    x=ans1
                if y==-1:
                    y=ans1
                m1=max(abs(x-y),m1)
            ans.append([ans1,m1])
        #print(ans,b)    
        if ans[0][1]<=ans[1][1]:
            print(ans[0][1],ans[0][0])
        else:
            print(ans[1][1],ans[1][0])
        
    #ans=0 