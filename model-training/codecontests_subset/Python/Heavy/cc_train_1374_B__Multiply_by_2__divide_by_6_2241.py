t = int(input())

while t:
    t-=1
    n = int(input())
    if n==1:
        print(0)
    ans = 0
    count =0
    stop = False

    if n ==2:
        print(-1)
        continue
    if n==3:
        print(2)
        continue
    if n >3:

        while 1:
            if n%6 !=0:
                n*=2
                count+=1
                if n%6 !=0:
                    print(-1)
                    stop = True
                    break
            n/=6
            count +=1
            if n==1:
                print(count)
                stop = True
                break

        if stop:
            continue
