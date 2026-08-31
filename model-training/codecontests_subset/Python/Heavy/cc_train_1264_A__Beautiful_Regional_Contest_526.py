t=int(input())
for tt in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    arr.sort(reverse=True)
    cc=0
    g=1
    check=arr[0]
    index=0
    for i in range(1,n//2):
        if check==arr[i]:
            g+=1 
        else:
            index=i 
            break
    s=0
    lol=index
    check=arr[index]
    for i in range(index,n//2):
        if check==arr[i]:
            s+=1 
        else:
            if g>=s:
                s+=1 
                check=arr[i]
            else:
                lol=i 
                break
    b=(n//2)-(s+g)
    lol=arr[n//2]
    i=(n//2)-1
    while i>=0 and b>0:
        if lol==arr[i]:
            i-=1 
            b-=1 
        else:
            break
    if g>=s or g>=b:
        print("0 0 0")
        continue
    if b<=0 or s<=0 or g<=0:
        print("0 0 0")
    else:
        print(g,s,b)
    