T = int(input())
for t in range(T):
    N = int(input())
    arrP = []
    arrC = []
    for n in range(N):
        p, c = input().split(' ')
        arrP.append(int(p))
        arrC.append(int(c))
    if arrP[0] < arrC[0]:
        print("NO")
    else :
        flag = True
        for n in range(1,N):
            if(arrP[n] < arrC[n] or arrP[n] < arrP[n-1] or arrC[n] < arrC[n-1] or arrP[n] - arrP[n-1] < arrC[n] - arrC[n-1]):
                flag = False
                print("NO")
                break
        if flag:
            print("YES")