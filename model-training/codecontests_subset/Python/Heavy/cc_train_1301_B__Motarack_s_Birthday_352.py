t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int,input().split()))

    cnt = 1 if a[0] != -1 and a[1] == -1 else 0
    maxdif = 0
    max_ai = a[0] if a[0] != -1 and a[1] == -1 else 0
    min_ai = a[0] if a[0] != -1 and a[1] == -1 else 10**9
    for i in range(1,n-1):
        if a[i-1] != -1 and a[i] != -1:
            maxdif = max(maxdif,abs(a[i]-a[i-1]))
        if a[i] != -1 and (a[i-1] == -1 or a[i+1] == -1):
            min_ai = min(min_ai,a[i])
            max_ai = max(max_ai,a[i])
            cnt += 1
    if a[n-2] != -1 and a[n-1] != -1:
            maxdif = max(maxdif,abs(a[n-1]-a[n-2]))
    if a[n-1] != -1 and a[n-2] == -1: 
            min_ai = min(min_ai,a[n-1])
            max_ai = max(max_ai,a[n-1])
            cnt += 1

    if cnt != 0:
        avg = (max_ai+min_ai)//2
        print(max(max_ai-avg,maxdif),avg)
    else:
        print(0,0)
    