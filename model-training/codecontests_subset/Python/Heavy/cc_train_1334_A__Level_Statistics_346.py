from sys import stdin,stdout
ii1 = lambda: int(stdin.readline().strip())
is1 = lambda: stdin.readline().strip()
iia = lambda: list(map(int, stdin.readline().strip().split()))
isa = lambda: stdin.readline().strip().split()
mod = 1000000007

tc = ii1()
for _ in range(tc):
    n = ii1()
    arr = [[0,0]]
    for i in range(n):
        arr.append(iia())
    for i in range(1, n+1):
        if arr[i][1] > arr[i][0]:
            print("NO")
            break
        elif arr[i][0] < arr[i - 1][0] or arr[i][1] < arr[i - 1][1]:
            print("NO")
            break
        elif arr[i][0] - arr[i - 1][0] < arr[i][1] - arr[i - 1][1]:
            print("NO")
            break
    else:
        print("YES")