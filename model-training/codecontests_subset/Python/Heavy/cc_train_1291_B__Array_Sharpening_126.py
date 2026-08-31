import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    for i in range(n//2):
        if a[i] < i or a[n-i-1] < i:
            print('No')
            break
    else:
        if n % 2 == 0:
            x = a[n//2-1]
            y = a[n//2]
            if x < n//2-1 or y < n//2-1 or x == y == n//2-1:
                print('No')
            else:
                print('Yes')
        else:
            if a[n//2] < n//2:
                print('No')
            else:
                print('Yes')
