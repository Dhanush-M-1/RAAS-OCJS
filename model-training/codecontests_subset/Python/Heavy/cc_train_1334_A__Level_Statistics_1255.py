t = int(input())
while(t):
    t -= 1
    n = int(input())
    a = []
    for i in range(n):
        a.append(list(map(int, input().split())))
    if(n == 1):
        if(a[0][0] >= a[0][1]):
            print("YES")
        else:
            print("NO")
        continue
    for i in range(1, n):
        plays = a[i][0] - a[i-1][0]
        clears = a[i][1] - a[i-1][1]
        if not(a[i][0] >= a[i][1] and 
            plays >= 0 and 
            clears >= 0 and 
            plays >= clears):
                print("NO")
                break
    else:
        if(a[0][0] >= a[0][1]):
            print("YES")
        else:
            print("NO")