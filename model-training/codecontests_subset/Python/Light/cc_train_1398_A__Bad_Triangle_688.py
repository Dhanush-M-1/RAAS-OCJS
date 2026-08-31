# bad_triangle.py
for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    sm = a[0]+a[1]
    ok = True
    for i in range(n-1,1,-1):
        if a[i]>=sm:
            print(1,2,i+1)
            ok = False
            break
    if ok:
        print('-1')