for _ in range(int(input())):
    n=int(input())
    arr=[]
    for i in range(n):
        a=[int(i) for i in input().split()]
        arr.append(a)
    if arr[0][0]<arr[0][1]:
        print("NO")
    else:
        alive=True
        for i in range(1,n):
            if (arr[i][0]-arr[i-1][0]<arr[i][1]-arr[i-1][1]) or (arr[i][0]-arr[i-1][0])<0 or (arr[i][1]-arr[i-1][1])<0:
                alive=False
                break
        if alive:
            print("YES")
        else:
            print("NO")