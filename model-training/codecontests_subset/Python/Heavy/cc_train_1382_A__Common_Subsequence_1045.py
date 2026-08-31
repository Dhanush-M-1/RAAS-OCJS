t = int(input())
while(t):
    t -= 1
    n,m = list(map(int, input().split()))
    arr1 = list(map(int, input().split()))
    arr2 = list(map(int, input().split()))
    m = max([max(arr1), max(arr2)])
    arr = [0 for i in range(m+1)]
    for ele in arr1:
        arr[ele] = 1
    for ele in arr2:
        arr[ele] = 2 if arr[ele]==1 else arr[ele]
    
    ans= "NO"
    ans1=  0
    for i in range(len(arr)):
        if(arr[i]>1):
            ans = "YES"
            ans1 = i
            break
    if(ans=="YES"):
        print(ans)
        print(1, ans1)
    else:
        print("NO")