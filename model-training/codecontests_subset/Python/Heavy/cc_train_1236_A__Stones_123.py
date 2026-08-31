t = int(input())
for i in range(0,t):
    a,b,c = map(int,input().split())
    count = 0
    if b == 0:
        print(0)
    if b == 1:
        if c>=2:
            print(3)
        else:
            print(0)
    if b>=2 :
        if c==0 or c==1:
            if a==0:
                print(0)
            if a>=1:
                p=b//2
                count+=p
                print(min(count,a)*3)
        if c>=2:
            p=c//2
            count+=min(p,b)
            b=b-p
            if a==0:
                print(count*3)
            if a>=1:
                if b>0:
                    q=b//2
                    count = count + min(q,a)
                    print(count*3)
                else:
                    print(count*3)


