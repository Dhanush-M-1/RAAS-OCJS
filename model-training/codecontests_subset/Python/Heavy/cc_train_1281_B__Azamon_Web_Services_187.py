t=int(input())
for _ in range(t):
    x=list(map(str,input().split()))
    arr=list(map(str,x[0].strip()))
    n=len(arr)
    brr=list(map(str,x[1].strip()))
    m=len(brr)
    post=[]
    x=arr[n-1]
    ind=n-1
    for i in range(n-1,-1,-1):
        if(arr[i]<x):
            x=arr[i]
            ind=i
        post+=[[x,ind]]
    post.reverse()
    for i in range(min(n,m)):
        if(arr[i]<brr[i]):
            break
        elif(i==n-1):
            break
        elif(arr[i]==brr[i] and i!=n-1):
            temp=arr[i]
            if(temp>post[i+1][0]):
                arr[i],arr[post[i+1][1]]=arr[post[i+1][1]],arr[i]
                break
        else:
            temp=arr[i]
            if(temp>post[i+1][0]):
                arr[i],arr[post[i+1][1]]=arr[post[i+1][1]],arr[i]
                break
            elif(temp==post[i+1][0]):
                arr[i],arr[post[i+1][1]]=arr[post[i+1][1]],arr[i]
            else:
                break
    if(arr<brr):
        print(''.join(arr))
    else:
        print('---')
                
            
        