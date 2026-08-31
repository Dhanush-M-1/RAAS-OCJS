t = int(input())
for _ in range(t):
    n = int(input())
    l = list(map(int, input().split()))

    if (n == 1):
        print("Yes")
        continue
    after = 0
    flag = True
    printed = False
    bool1 = [False] * n
    bool2 = [False] * n
    for i in range(n):
        if l[i] >= i: bool1[i] = True
        if l[i] >= n-i-1: bool2[i] = True
            
    a = 0
    while (a < n and bool1[a]):
        a+=1
    if a == n:
        print("Yes")
        continue
    else:
        a -= 1
        while(a < n and bool2[a]):
            a+=1
        if a == n:
            print("Yes")
        else:
            print("No")



