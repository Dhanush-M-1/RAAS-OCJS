t=int(input())

while t>0:
    t-=1
    n=int(input())
    arr=[]
    for i in range(n):
        a=input()
        b=[]
        for i in range(n):
            b.append(a[i])
        arr.append(b)


    if arr[0][1]==arr[1][0]:
        ans=[]
        if arr[2][0]==arr[0][1]:
            ans.append([2,0])
        if arr[1][1]==arr[0][1]:
            ans.append([1,1])
        if arr[0][2]==arr[0][1]:
            ans.append([0,2])

        if len(ans)<3:
            print(len(ans))
            for i in range(len(ans)):
                print(ans[i][0]+1,ans[i][1]+1)
        else:
            print(2)
            print(1,2)
            print(2,1)
    else:
        if arr[1][1]==arr[2][0] and arr[1][1]==arr[0][2]:
            print(1)
            if arr[1][0]==arr[1][1]:
                print(2,1)
            else:
                print(1,2)

            continue
        if arr[2][0]==arr[1][1]:
            print(2)
            if arr[0][2]==arr[1][0]:
                print(1,2)
            else:
                print(2,1)
            print(1,3)
        else:
            if arr[1][1]==arr[0][2]:
                print(2)
                print(3,1)
                if arr[2][0]!=arr[1][0]:
                    print(2,1)
                else:
                    print(1,2)
            else:
                print(2)
                print(2,2)
                if arr[1][1]!=arr[1][0]:
                    print(2,1)
                else:
                    print(1,2)
