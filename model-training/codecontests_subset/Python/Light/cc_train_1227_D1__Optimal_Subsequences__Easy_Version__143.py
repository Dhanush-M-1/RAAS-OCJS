n = int(input())
a = list(map(int,input().split()))
for i in range(n):
    a[i] = (a[i],-i)
a.sort()
m = int(input())
for j in range(m):
    t = list(map(int, input().split()))
    k = t[0]
    p = t[1]
    print(sorted(a[-k:], key = lambda x: -x[1])[p-1][0])