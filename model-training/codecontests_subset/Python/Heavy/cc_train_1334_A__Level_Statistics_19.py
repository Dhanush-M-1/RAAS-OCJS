t = int(input())
while t >0:
    t = t-1
    n = int(input())
    attempts = []
    clears = []
    for i in range(n):
        p,c = map(int,input().split())
        attempts.append(p)
        clears.append(c)
    c = 0
    for i in range(1,n):
        if attempts[i]>=attempts[i-1] and clears[i]>=clears[i-1] and attempts[i]>=clears[i] and attempts[i]-attempts[i-1]>=clears[i]-clears[i-1]:
            continue
        else:
            c = 1
            break
    if attempts[0]<clears[0]:
        c = 1
    if c == 0:
        print("YES")
    else:
        print("NO")