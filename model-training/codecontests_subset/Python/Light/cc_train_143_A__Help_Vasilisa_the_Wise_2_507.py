def solution(r,c,d):
    n1=n2=n3=n4=0
    for i in range(1,10):
        n1=i
        n2=r[0]-i
        n3=c[0]-i
        n4=d[0]-i

        if (n2 in range(1,10)) and (n3 in range(1,10)) and (n4 in range(1,10)) and n1!=n2 and n1!=n3 and n1!=n4 and n2!=n3 and n2!=n4 and n3!=n4:
            if n3+n4==r[1] and n2+n4==c[1] and n2+n3==d[1]:
                print("{} {}".format(n1,n2))  
                print("{} {}".format(n3,n4))
                return

    print(-1)




r=list(map(int,input('').split()))
c=list(map(int,input('').split()))
d=list(map(int,input('').split()))
solution(r,c,d)