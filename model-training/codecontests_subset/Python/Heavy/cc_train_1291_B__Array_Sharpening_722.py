t = int(input())
for _ in range(t):
    n = int(input())
    l = [int(i) for i in input().split()]
    if(n == 1):
        print("Yes")
        continue
    if(n == 2 and (l[0] != 0 or l[1] != 0)):
        print("Yes")
        continue
    elif(n == 2):
        print("No")
        continue
    a = 0
    for i in range(n):
        if(l[i] >= i):
            a = i
        else:
            break
    b = n - 1
    for i in range(n - 1, -1, -1):
        if(l[i] >= n - 1 - i):
            b = i
        else:
            break
    if(b == 0 or a == n - 1):
        print("Yes")
        continue
    if(b > a):
        print("No")
    else:
        print("Yes")