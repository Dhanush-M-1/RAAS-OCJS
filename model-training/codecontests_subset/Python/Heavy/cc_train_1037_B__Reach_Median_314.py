n,k = map(int,input().split())
greedy = list(map(int,input().split()))
greedy.sort()
ans = 0
if n == 1:
    ans += abs(greedy[0]-k)
else:
    if greedy[n//2] != k:
        if greedy[n//2] > k :
            ans += (greedy[n//2] - k)
            i = 1
            while n//2-i>=0 and greedy[n//2-i] > k :
                ans += (greedy[n//2-i] - k)
                i += 1
        else:
            ans += (k-greedy[n//2])
            i = 1
            while n//2+i<n and greedy[n//2+i] < k:
                ans += (k-greedy[n//2+i])
                i += 1
print(ans)
        
        
    