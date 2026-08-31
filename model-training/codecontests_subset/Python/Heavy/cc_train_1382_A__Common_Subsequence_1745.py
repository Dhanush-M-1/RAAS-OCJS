def solution(arr1,arr2):
    d = {}
    for i in arr1 :
        d[i] = d.get(i,0) + 1 
    
    ans = []
    for j in arr2 :
        val = d.get(j,0)
        if val > 0 :
            ans.append(j)
            return ans 
    return ans 
for _ in range(int(input())):
    n,k = map(int,input().split())
    arr1 = [int(x) for x in input().split()]
    arr2 = [int(x) for x in input().split()]
    ans = solution(arr1,arr2)
    if len(ans) == 0 :
        print('NO')
    else:
        print('YES')
        print(len(ans),end=' ')
        print(*ans)

    