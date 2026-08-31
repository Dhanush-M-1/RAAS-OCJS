for _ in range(int(input())):
    n=int(input())
    result=0
    if n==1:
        print(0)
        continue
    elif n%6!=0:
        n=2*n
        result+=1
        if n%6!=0:
            print(-1)
            continue
    while n>1:
        if n%6==0:
            n = n / 6
            result += 1
        else:
            n=2*n
            result+=1
            if n % 6 == 0:
                 n = n / 6
                 result += 1
            else:
                 print(-1)
                 break

    if n==1: print(result)