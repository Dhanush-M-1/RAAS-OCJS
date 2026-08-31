for _ in range(int(input())):
    N=int(input())
    L=list(map(int,input().split()))
    FLAG=0
    if N%2==0:
        n=N//2-1
    else:
        n=N//2+1
    for i in range(n):
        x=L[N-1-i]-i
        y=L[i]-i
        if x<0 or x>L[N-1-i] or y<0 or y>L[i]:
            FLAG=1
            break
    if FLAG==1:
        print("No")
    else:
        if N%2==0:
            if (L[N//2-1]>=N//2-1 and L[N//2]>=N//2) or (L[N//2-1]>=N//2 and L[N//2]>=N//2-1):
                print("Yes")
            else:
                print("No")
        else:
            if L[N//2]>=N//2:
                print("Yes")
            else:
                print("No")


