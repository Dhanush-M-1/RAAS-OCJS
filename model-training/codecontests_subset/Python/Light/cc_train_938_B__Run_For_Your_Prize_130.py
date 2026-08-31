n = int(input())

arr = [int(i) for i in input().split()]
ans = 0
for i in range(n):
    ans = max(ans,min(arr[i]-1,1000000-arr[i]))
print(ans)