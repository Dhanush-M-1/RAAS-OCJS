n = int(input())
a = list(map(int,input().split()))
x,y = 0,0
for i in range(n):
    x ^= a[i]
a = list(map(int,input().split()))
for i in range(n-1):
    x ^= a[i]
    y ^= a[i]
a = list(map(int,input().split()))
for i in range(n-2):
    y ^= a[i]
print(x),print(y)
