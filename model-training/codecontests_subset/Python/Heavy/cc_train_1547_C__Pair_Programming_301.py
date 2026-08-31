
t = int(input())


for _ in range(t):
    input()
    k,n,m = map(int, input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))

    ap = 0
    bp = 0
    ans = []
    # print(len(a),len(b),"asd")
    while True:
        if ap == len(a) and bp == len(b):break
        if ap < len(a) and a[ap] == 0:
            ans += [a[ap]] 
            ap += 1
            k += 1
        elif bp < len(b) and b[bp] == 0:
            ans += [b[bp]] 
            bp += 1
            k += 1
        elif (ap < len(a) and a[ap] <= k) or (bp < len(b) and b[bp] <= k):
            if bp == len(b):
                ans += [a[ap]] 
                ap += 1
            elif ap == len(a):
                ans += [b[bp]] 
                bp += 1
            elif a[ap] < b[bp]:
                ans += [a[ap]] 
                ap += 1
            else: 
                ans += [b[bp]]
                bp += 1
        else:
            print(-1)
            break
    if len(ans) == m + n:
        print(*ans)
