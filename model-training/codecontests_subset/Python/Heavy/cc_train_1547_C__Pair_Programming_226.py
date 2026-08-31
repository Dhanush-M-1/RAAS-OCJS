t = int(input())
def solve():
    input()
    k,n,m = map(int, input().split())
    arr1 = list(map(int, input().split()))
    arr2 = list(map(int, input().split()))
    p1 = 0
    p2 = 0
    ans = []
    while(p1 < len(arr1) or p2 < len(arr2)):
        if(p1 < len(arr1) and arr1[p1] <= k):
            if(arr1[p1] == 0):
                k += 1
            p1 += 1
            ans.append(arr1[p1 - 1])

        elif(p2 < len(arr2) and arr2[p2] <= k):
            if(arr2[p2] == 0):
                k += 1
            p2 += 1
            ans.append(arr2[p2 - 1])
        else:
            print("-1")
            return
    print(*ans)
for i in range(t):
    solve()