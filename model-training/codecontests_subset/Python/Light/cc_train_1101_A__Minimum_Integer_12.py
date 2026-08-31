n = int(input())
for i in range(n):
    l,r,d = map(int,input().split())
    '''a = l // d
    b = r // d

    ans1 = a*d
    ans2 = b*d

    if ans1 < l and ans1 != 0:
        print(ans1)
    else:
        if ans2 > r:
            print(ans2)
        else:
            print(ans2+d)
     '''   
    if d < l:
        print(d)
    else:
        print((r//d+1)*d)
