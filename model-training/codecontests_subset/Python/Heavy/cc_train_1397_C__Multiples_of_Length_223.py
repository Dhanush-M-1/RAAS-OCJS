import sys
input=sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))

g = []

for i in range(n-1):
    t = arr[i] % (n)
    g.append(t * (n-1))
    arr[i] += t * (n-1)
    
if n==1:
    print(1, 1)
    print(-arr[0])
    print(1, 1)
    print(0)
    print(1, 1)
    print(0)
elif n==2:
    print(1, 1)
    print(-arr[0])
    print(2, 2)
    print(-arr[1])
    print(1, 1)
    print(0)
else:
    print(1, n-1)
    print(*g)
    print(n,n)
    print(- (arr[-1] % n))
    
    arr[-1] += - (arr[-1] % n)
    
    g = []
    
    for num in arr:
        g.append(- (num))
        
    print(1,n)
    print(*g)