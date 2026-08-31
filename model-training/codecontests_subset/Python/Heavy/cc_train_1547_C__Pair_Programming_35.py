t = int(input())
for _ in range(t):
    dummy = input()
    k, m , n = list(map(int,input().rstrip().split()))
    arrm = list(map(int,input().rstrip().split()))
    arrn = list(map(int,input().rstrip().split()))
    final = []
    pm = 0
    pn = 0
    count=0
    while pm < m or pn < n:
        if pm < m and arrm[pm] == 0:
            final.append(arrm[pm])
            pm+=1
            k+=1
        elif pn < n and  arrn[pn] == 0:
            final.append(arrn[pn])
            pn+=1
            k+=1
        else:
            if pm < m and arrm[pm] <= k:
                final.append(arrm[pm])
                pm+=1
            elif pn < n and arrn[pn] <= k:
                final.append(arrn[pn])
                pn+=1
            else:
                break
    if pm < m or pn < n:
        print(-1)
    else:
        print(*final)
    

            