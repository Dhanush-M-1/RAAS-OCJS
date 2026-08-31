for _ in range(int(input())):
    n=int(input())
    su=0
    se=0
    sk=0
    sj=0
    count=0
    if n==1:
        print(0)
    else:
        while n!=1:
            if n%6==0:
                count+=1
                n=n//6
            elif n%6!=0:
                n*=2
                count+=1
                if n%6==0:
                    count+=1
                    n=n//6
                else:
                    se+=1
                    print(-1)
                    break
        if se!=1:
            print(count)