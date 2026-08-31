'''n = int(input())
a = [0]*n
b = [0]*n
c = [0]*n
for i in range(n):
    a[i],b[i],c[i] = map(int,input().split())
for i in range(n):
    ans = 0
    if c[i]//2 <= b[i]:
        ans += 3*(c[i]//2)
        b[i] -= c[i]//2
    else:
        ans += 3*(b[i])
        b[i] = 0
    if b[i]//2 <= a[i]:
        ans += 3*(b[i]//2)
    else:
        ans += 3*(a[i])
    print(ans)'''

n = int(input())
a = [0]*n
b = [0]*n
c = [0]*n
for i in range(n):
    a[i],b[i],c[i] = map(int,input().split())
    ans = 0
    flag = True
    while flag:
        flag = False
        if c[i] > 1 and b[i] > 0:
            c[i] -= 2
            b[i] -= 1
            ans += 3
            flag = True
        elif a[i] > 0 and b[i] > 1:
            b[i] -= 2
            a[i] -= 1
            ans += 3
            flag = True
    print(ans)