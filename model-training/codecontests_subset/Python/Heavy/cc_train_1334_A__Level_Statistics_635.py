for _ in range(int(input())):
    n=int(input())
    arr=[]
    for i in range(n):
        a=list(map(int,input().split()))
        arr.append(a.copy())

    ch=1
    for i in range(n):
        if(arr[i][0]<arr[i][1]):
            print("NO")
            ch=0
            break
        if(i>0):
            if(arr[i][0]<arr[i-1][0] or arr[i][1]<arr[i-1][1]):
                print("NO")
                ch=0
                break
            elif((arr[i][1]-arr[i-1][1])>(arr[i][0]-arr[i-1][0])):
                print("NO")
                ch=0
                break
    if(ch==1):
        print("YES")











