cases = int(input())
for cas in range(cases):
    n = int(input())
    r = list(map(int, input().split()))
    c = list(map(int, input().split()))
    rc = []
    for i in range(n):
        rc.append((r[i], c[i]))
    rc.sort(key=lambda x: x[0])
    if(rc[0] != (1, 1)):
        rc.insert(0, (1, 1))
    ans = 0
    for i in range(0, len(rc)-1):
        sum1, sub1 = rc[i][0]+rc[i][1], rc[i][0]-rc[i][1]
        sum2, sub2 = rc[(i+1)][0]+rc[(i+1)][1], rc[(i+1)][0]-rc[(i+1)][1]
        if(sub1 == sub2):
            if(sum1 % 2 == 0):
                ans += (sum2-sum1)//2
            else:
                ans += 0
        else:
            if(sub1 % 2 == 0):
                ans += (sub2-sub1)//2
            else:
                ans += (sub2-sub1+1)//2
    print(ans)
