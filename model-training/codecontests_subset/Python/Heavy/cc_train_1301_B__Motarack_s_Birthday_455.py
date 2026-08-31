t=int(input())
 
for _ in range(t):
    n=int(input())
    arr=list(map(int, input().strip().split()))
 
    cnt=0
    for i in arr:
        if(i==-1):
            cnt+=1
    if(cnt==n):
        print(0,0)
    else:
 
        raj=set()
        for i in range(n):
            if(arr[i]==-1):
                if(i==0):
                    if(arr[1]!=-1):
                        raj.add(1)
                elif(i==n-1):
                    if(arr[i-1]!=-1):
                        raj.add(i-1)
                else:
                    if(arr[i-1]!=-1):
                        raj.add(i-1)
                    if(arr[i+1]!=-1):
                        raj.add(i+1)
        
        tot=0
        lol=[]
        for i in raj:
            lol.append(arr[i])
        lol=sorted(lol)
        rep=((lol[0]+lol[-1])//2)
        for i in range(n):
            if(arr[i]==-1):
                arr[i]=rep
 
        check=[0]*(n-1)
        for i in range(1,n):
            check[i-1]=abs(arr[i]-arr[i-1])
 
        print(max(check),rep)
