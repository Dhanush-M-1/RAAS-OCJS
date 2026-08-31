r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
if r1+r2==c1+c2==d1+d2:
    if r1==c1 or r1==c2 or r1==d1 or r1==d2 or r2==c1 or r2==c2 or r2==d1 or r2==d2 or c1==d1 or c1==d2 or c2==d1 or c2==d2:
        print(-1)
    else:
        if (d1+r1-c2)%2==0 and (c1+r1-d2)%2==0:
            if (d1+r1-c2)==(c1+r1-d2):
                if (d1+r1-c2)//2 ==(d1+r1-c2)/2>0:
                    a=(d1+r1-c2)//2
                    if 0<a<10 and 0<r1-a<10 and 0<c1-a<10 and 0<d1-a<10:
                        print(a,r1-a)
                        print(c1-a,d1-a)
                    else:
                        print(-1)
                else:
                    print(-1)
                
            else:
                print(-1)
        else:
            print(-1)
    
else:
    print(-1)