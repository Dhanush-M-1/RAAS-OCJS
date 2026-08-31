from sys import stdin
input = stdin.readline


t = int(input())

for _ in range(t):

    n = int(input())
    a = list(map(int,input().split()))

    half = n//2 - 1

    while half>=0 and half+1<n and a[half+1] == a[half]:
        half -= 1


    g = 1
    i = 0
    while i + 1 <= half and a[i] == a[i+1]:
        g += 1
        i += 1

    i += 1
    s = 0
    b = 0
    j = i

    while j <= half:
        flag = 0
        while j+1 <= half and a[j] == a[j+1]:
            j += 1
        if j-i+1 > g and half - j + 1 > g:
            s = j-i+1
            b = half - j
            flag = 1
            break
        if flag:
            break
        j += 1

    if g<b and g<s:
        print(g,s,b)
    else:
        print(0,0,0)























