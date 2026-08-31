from sys import stdin, stdout
import collections
for _ in range(int(input())):
    n, l, r = map(int, input().split())
    loop = r-l+1
    if r==n*(n-1)+1:
        loop-=1
    ans = ""
    t_l = 2*(n-1)
    t_r = 2*(n-1)
    i = 1
    while l>t_l:
        i += 1
        if i!=n:
            t_l+=2*(n-(i))
        else:
            t_l+=1
    t_l-=2*(n-(i))
    l-=t_l

    for m in range(loop):
        if l % 2 == 0:
            print(i+l//2,end =" ")
            if i + l // 2 == n:
                i += 1
                l = 1
            else:
                l += 1
        else:
            print(i, end = " ")
            l+=1
    if r == n * (n - 1) + 1:
        print("1", end = " ")
    print()
    #print(ans)

