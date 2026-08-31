import sys

for _ in range(int(sys.stdin.readline())):
    n = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split()))
    max1 = 0
    b = []
    for i in range(n-1):
        if a[i] == -1 and a[i+1] != -1:
            b.append(a[i+1])
            continue
        if a[i] != -1 and a[i+1] == -1:
            b.append(a[i])
            continue
        if abs(a[i]-a[i+1]) > max1:
            max1 = abs(a[i]-a[i+1])
    if b == []:
        print(max1, 0)
        continue
    max2 = (max(b)-min(b)+1)//2
    k = (max(b)+min(b))//2
    print(max(max1, max2), k)