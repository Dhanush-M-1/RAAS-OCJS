t = int(input())
for T in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    if a == [-1]*len(a):
        print(0, 1)
        continue
    mi = 10**9 + 1
    ma = -1
    if n == 1:
        print(0, a[0])
        continue
    for i in range(len(a)):
        if a[i] != -1:
            if i > 0:
                if a[i-1] == -1:
                    mi = min([mi,a[i]])
                    ma = max([ma,a[i]])
            if i < len(a)-1:
                if a[i+1] == -1:
                    mi = min([mi,a[i]])
                    ma = max([ma,a[i]])
    k = (mi + ma)//2
    for i in range(len(a)):
        if a[i] == -1:
            a[i] = k
    m = 0
    for i in range(len(a)-1):
        m = max(m, abs(a[i]-a[i+1]))
    print(m,k)