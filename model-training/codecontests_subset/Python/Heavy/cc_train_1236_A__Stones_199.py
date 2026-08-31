for _ in range(int(input())):
    a,b,c = [int(z) for z in input().split()]
    ans = 0
    if b == 0:
        print(0)
    else:
        
        while c >= 2 and b > 0:
            ans += 3
            b-=1 
            c-=2
        while b >= 2 and a > 0:
            ans += 3
            b-=2
            a -= 1
    #    print(ans)
    #else:
    #    while b >= 2 and a > 0:
    #        ans += 3
    #        b-=2
    #        a -= 1
    #    while c >= 2 and b > 0:
    #        ans += 3
    #        b-=1 
    #        c-=2
#
        print(ans)