n, k = list(map(int, input().split()))
arr = list(map(int, input().split()))
max_el = 0
for i in range(n):
    if k % arr[i] == 0:
        if max_el < arr[i]:
            max_el = arr[i]
print(k // max_el)

    
