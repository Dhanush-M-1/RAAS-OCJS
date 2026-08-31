for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    
    arr=[]
    for i in range(n):
        if a[i]==-1:
            if i==0 : 
                if a[i+1]>=0:arr.append(a[i+1])
            elif i==n-1 :
                if a[i-1]>=0:arr.append(a[i-1])
            else:
                if a[i-1]>=0:arr.append(a[i-1])
                if a[i+1]>=0:arr.append(a[i+1])
    if len(arr)==0:
        print("0 3")
    else:
        mn=min(arr)
        m=max(arr)
        x=(mn+m)//2 
        ans=[]
        for i in range(0,n):
            if a[i]==-1 :
                a[i]=x
        for i in range(1,n):
            ans.append(abs(a[i]-a[i-1]))
        print(max(ans),x)
            
                
                
                
            
        