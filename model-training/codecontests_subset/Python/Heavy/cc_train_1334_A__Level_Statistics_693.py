t=int(input())
while t>0:
    t-=1
    n=int(input())
    arr=[]
    for i in range(n):
        pair=list(map(int,input().split()))
        arr.append(pair)
    c=0
    p=0
    flag=True
    d={}
    for i in range(len(arr)):
        if arr[i][0] < arr[i][1] or arr[i][1] < c or arr[i][0] < p or arr[i][1]-c > arr[i][0]-p:
            flag=False
            break
        if arr[i][0] in d.keys():
            if arr[i][1] != d[arr[i][0]] :
                flag=False
                break
        else:
            d[arr[i][0]] =arr[i][1]
        c,p=arr[i][1],arr[i][0]
    if flag:
        print("YES")
    else:
        print("NO")