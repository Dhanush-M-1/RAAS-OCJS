t=int(input())
for _ in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    a=[]
    for i in range(n):
        if arr[i]==-1:
            if i>0 and arr[i-1]!=-1:
                a.append(arr[i-1])
            if i<n-1 and arr[i+1]!=-1:
                a.append(arr[i+1])
    
    if len(a)!=0:        
        k=(max(a)+min(a))//2
        m=0
        for j in range(n):
            if arr[j]==-1:
                arr[j]=k
            if (j):
                m=max(m,abs(arr[j]-arr[j-1]))
        print(m,k)
    else:
        print(0,42)
        
    
