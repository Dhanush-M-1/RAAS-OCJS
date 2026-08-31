for _ in range(int(input())):
    n = int(input())
    arr=[int(a) for a in input().split()]
    b = []
    md=0
    k=42
    for i,item in enumerate(arr):
        if(item>-1):
            if(i>0):
                if(arr[i-1]>-1):
                    md = max(md,abs(arr[i-1]-arr[i]))
                if(arr[i-1]==-1):
                    b.append(item)
            if(i<n-1):
                if(arr[i+1]>-1):
                    md = max(md,abs(arr[i]-arr[i+1]))    
                if(arr[i+1]==-1):
                    b.append(item)
    if(b!=[]):
        k = (max(b) + min(b))//2
        md = max(md, max(abs(k-max(b)),abs(k-min(b))))
    print(md,k)