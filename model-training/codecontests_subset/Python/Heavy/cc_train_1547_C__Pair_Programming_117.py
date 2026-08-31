T = int(input())

for i in range(T):
    input()
    K,N,M = map(int, input().split())
    
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    # standart_input
    
    
    if A.count(0)+B.count(0)+K < max(A+B):
        print(-1)
        # Expection handling
    
    else:
        ans = []
        l_A = 0
        l_B = 0
        
        for i in range(N+M):
            # print(N,M,i,l_A,l_B,"A,B:",A[l_A:],B[l_B:])
            
            if l_A < N and l_B < M:
                if A[l_A] < B[l_B]:
                    ans.append(A[l_A])
                    l_A += 1
                    
                else:
                    ans.append(B[l_B])
                    l_B += 1
                    
            
            elif l_A < N:
                ans.append(A[l_A])
                l_A += 1
                
            else:
                ans.append(B[l_B])
                l_B += 1
        
        rows = K
        f = True
        # f is (ans == correct)
        for j in range(N+M):
            if ans[j] == 0:
                rows += 1
            elif ans[j] > rows:
                f = False
            
        if f:
            print(*ans)
        else:
            print(-1)