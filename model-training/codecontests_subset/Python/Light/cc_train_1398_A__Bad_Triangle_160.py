n = int(input())
for _ in range(n):
    m = int(input())
    arr = list(map(int, input().split()))
    x = arr[0]+arr[1]
    flag = False
    for i in range(2, len(arr)):
        if x <= arr[i]:
            print(f"1 2 {i+1}")
            flag = True
            break
    if not flag:
        print("-1")