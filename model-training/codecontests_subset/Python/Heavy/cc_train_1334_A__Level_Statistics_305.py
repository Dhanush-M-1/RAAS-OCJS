t = int(input())
while t > 0:
    n = int(input())
    L = []
    flag = 0
    while n > 0:
        p, c = list(map(int, input().split()))
        L.append([p,c])
        n -= 1
    if (L == sorted(L)):
        flag = 1
    
    counter = 0
    if (flag):
        if len(L) > 1:
            for i in range (len(L)-1):
                if L[i][0] < L[i][1]:
                    counter += 1
                    break
                elif L[i][0] > L[i+1][0]:
                    counter += 1
                    break
                elif L[i][1] > L[i+1][1]:
                    counter += 1
                    break
                elif (L[i+1][0] - L[i][0] < L[i+1][1] - L[i][1]):
                    counter += 1
                    break
                else:
                    continue
        else:
            if p >= c:
                print("YES")
            else:
                print("NO")
        if counter == 0 and len(L) > 1:
            print("YES")
        elif counter > 0 and len(L) > 1:
            print("NO")
    else:
        print("NO")
    t -= 1