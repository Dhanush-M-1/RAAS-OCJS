n = input()
n = int(n)
x = []
ans = 1
if n == 1:
    print(ans)
else:
    for i in range(n):
        xi,hi = input().strip().split()
        xi = int(xi)
        hi = int(hi)
        x.append([xi,hi])
    for i in range(1,n-1):
        if x[i][0] - x[i-1][0] > x[i][1]:
            ans += 1
            #print(ans,"i:",i)
        elif x[i+1][0] - x[i][0] > x[i][1]:
            x[i][0] = x[i][0] + x[i][1]
            ans += 1
            #print(ans,"i:",i)
    print(ans+1)
