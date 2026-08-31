for _ in range(int(input())):
    n = int(input())
    a = []
    t = 1
    for i in range(n):
        a.append(list(map(int, input().split())))
    if(a[0][0] < a[0][1]):
        t = 0
    for i in range(n-1):
        if(a[i][0] < a[i+1][0]):
            if((a[i+1][0]-a[i][0]) < (a[i+1][1]-a[i][1])) or (a[i][1] > a[i+1][1]):
                t = 0
                break
        elif(a[i][0] > a[i+1][0]):
            t = 0
            break
        else:
            if(a[i][1] != a[i+1][1]):
                t = 0
                break
    if(t == 0):
        print("NO")
    else:
        print("YES")