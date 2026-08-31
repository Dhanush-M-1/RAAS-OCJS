t = int(input())
for test in range(t):
    n = int(input())
    stats = []
    for i in range(n):
        stats.append([int(x) for x in input().split()])
    if stats[0][0]<stats[0][1]:
        print("NO")
        continue
    f=0
    for i in range(1,n):
        x = stats[i][0]-stats[i-1][0]
        if x<0:
            f=1
            break
        else:
            y = stats[i][1]-stats[i-1][1]
            if x<y or y<0:
                f=1
                break
    if f==1:
        print("NO")
    else:
        print("YES")
            
