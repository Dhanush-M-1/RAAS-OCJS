import sys
input = lambda: sys.stdin.readline().rstrip()
t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    if n==1:
        print('Yes')
        continue
    if n==2:
        if sum(a)==0:
            print('No')
        else:
            print('Yes')
        continue
    inc = True
    a[0] = 0
    for i in range(n-1):
        if inc:
            if a[i]==a[i+1]:
                inc = False
                a[i+1] -= 1
            elif a[i]<a[i+1]:
                if i==n-2 or a[i]+1!=a[i+2]:
                    a[i+1] = a[i] + 1
            else:
                inc = False
        else:
            if a[i]<=a[i+1]:
                a[i+1] = a[i] - 1
    if a[-1]>=0:
        print('Yes')
    else:
        print('No')