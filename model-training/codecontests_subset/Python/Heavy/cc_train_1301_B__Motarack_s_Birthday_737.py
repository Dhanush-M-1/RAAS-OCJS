for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    mn = 10**9
    mx=-1
    for i in range(n):
        if i >0 and arr[i]==-1 and arr[i-1]!=-1:
            mn = min(mn,arr[i-1])
            mx = max(mx,arr[i-1])
        if i<n-1 and arr[i]==-1 and arr[i+1]!=-1:
            mn = min(mn,arr[i+1])
            mx = max(mx,arr[i+1])

    res = (mn+mx)//2
    ans =0
    for i in range(n):
        if arr[i]==-1 :
            arr[i]=res
        if i:
            ans = max(ans,abs(arr[i]-arr[i-1]))
    print (ans,res)
