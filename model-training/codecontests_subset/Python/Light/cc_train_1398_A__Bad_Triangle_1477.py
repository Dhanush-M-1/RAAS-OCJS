

for _ in range(int(input())):
    
    N = int(input())
    
    A = list(map(int, input().split()))
    
    A = [[A[i], i + 1] for i in range(N)]
    
    A.sort()
    
    if A[0][0] + A[1][0] <= A[-1][0]:
        
        ans = [A[0][1], A[1][1], A[-1][1]]
        
    else:
        
        ans = [-1]
        
    ans.sort()
    
    print(*ans)