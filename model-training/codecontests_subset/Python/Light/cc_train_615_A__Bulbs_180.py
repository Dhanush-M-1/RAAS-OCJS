n, m = list(map(int, input().split()))
arr = [0 for i in range(m)]
for i in range(n) :
    brr = list(map(int, input().split()))
    
    for j in brr[1: ]:
        arr[j - 1] += 1

if 0 in arr:
    print("NO")
else:
    print("YES")

