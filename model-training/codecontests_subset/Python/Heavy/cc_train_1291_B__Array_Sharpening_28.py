'''t = int(input())
for _ in range(t):
    k = int(input())
    st = input()
    n = [int(i) for i in st]
    s = sum(n)
    ans = ''
    last = 1
    sw = 0
    cnt = 1
    while last <= k and n[-last] % 2 == 0:
        sw += n[-last]
        last += 1
    s -= sw
    if last > k:
        ans = '-1'
    elif s % 2 != 0:
        for i in range(k - last + 1):
            if n[i] % 2 != 0 and k - i != last:
                ans += st[i + 1: k - last + 1]
                cnt = 0
                break
            else:
                ans += st[i]
        if cnt:
            ans = '-1'
    else:
        if last == 1:
            ans = st
        else:
            ans = st[: k - last + 1]
            
    print(int(ans))'''

def c(n, a):
    for i in range(n):
        if a[i] < i:
            return i  
    return n
        
for _ in range(int(input())):
    n = int(input())
    a = [int(i) for i in input().split()]
    #b = [[a[i], i] for i in range(n)]
    #b.sort()   
    cntl = c(n, a)
    cntr = n - 1 - c(n, a[::-1])
    if cntl <= cntr or cntl - cntr == 1:
        print('No')
    else:
        print('Yes')

        