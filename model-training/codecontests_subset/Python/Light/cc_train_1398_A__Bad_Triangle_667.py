def algo(a, N):
    if a[0]+a[1]<=a[-1]:
        s="1"+" "+"2"+" "+str(n)
        return s
    return -1

for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    print(algo(a,n))