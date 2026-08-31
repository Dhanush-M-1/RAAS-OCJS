test = int(input())
for _ in range(test):
    N = int(input())
    LIST = list(map(int,input().split()))
    F=0
    if N%2 == 0:
        n=N//2-1
    else:
        n=N//2+1
    for i in range(n):
        ans = LIST[N-1-i]-i
        res = LIST[i]-i
        if ans < 0 or ans > LIST[N-1-i] or res < 0 or res > LIST[i]:
            F=1
            break
    if F==1:
        print("No")
    else:
        if N%2==0:
            if ( LIST[N//2-1] >= N//2-1 and LIST[N//2] >= N//2) or (LIST[N//2-1] >= N//2 and LIST[N//2] >= N//2-1):
                print("Yes")
            else:
                print("No")
        else:
            if LIST[N//2] >= N//2:
                print("Yes")
            else:
                print("No")