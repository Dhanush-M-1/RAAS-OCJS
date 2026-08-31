n = int(input())
arr = [0] * (n+1)
for _ in range(n-1):
    a,b = map(int,input().split())
    arr[a] += 1
    arr[b] += 1

for i in range(1,n+1):
    if arr[i] == 2:
        print("NO")
        break
else:
    print("YES")
