test = int(input())
for _ in range(test):
    n,m = map(int,input().split())
    arr1 = list(map(int,input().split()))
    arr2 = list(map(int,input().split()))
    arr = []
    flag = 0
    if n>m:
        for i in arr1:
            if i in arr2:
                flag = 1
                arr.append(i)
                break
    else:
        for i in arr2:
            if i in arr1:
                flag = 1
                arr.append(i)
                break
    if flag==0:
        print("NO")
    else:
        print("YES")
        print(len(arr),' ',arr[0])