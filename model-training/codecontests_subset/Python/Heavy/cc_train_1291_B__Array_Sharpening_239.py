# cook your dish here

def check(n, a):
    for i in range(n//2):
        if (a[i] < i):
            return 0
    j = 0
    for i in range(n-1, n//2-1, -1):
        if (a[i] < j):
            return 0
        j += 1
        
    if (n%2 == 0):
        if (a[n//2-1] == a[n//2] and a[n//2] == n//2-1):
            return 0
    
    return 1

for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    if (check(n, a)):
        print("YES")
    else:
        print("NO")