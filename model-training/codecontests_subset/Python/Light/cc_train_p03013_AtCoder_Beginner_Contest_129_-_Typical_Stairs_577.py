N , M = (int(a) for a in input().split())
stair = [1]*(N+1)
for i in range(1 , M+1) :
    a = int(input())
    stair[a] = 0
 
for i in range(2, N+1) :
    stair[i] *= (stair[i-1] + stair[i-2]) % (10**9+7)
         
print(stair[N])