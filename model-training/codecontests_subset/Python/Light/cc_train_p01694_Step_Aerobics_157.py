while True:
    n = int(input())
    if n==0:
        break

    f = list(input().split())
    cnt = 0
    rf = 0
    lf = 0
    foot = 0
    for i in range(n):
        if lf==0 and f[i]=="lu":
            lf = 1
        elif rf==0 and f[i]=="ru":
            rf = 1
        if foot==0 and lf==1 and rf==1:
            cnt += 1
            foot = 1
        if lf==1 and f[i]=="ld":
            lf = 0
        elif rf==1 and f[i]=="rd":
            rf = 0
        if foot==1 and lf==0 and rf==0:
            cnt += 1
            foot = 0
    print(cnt)
