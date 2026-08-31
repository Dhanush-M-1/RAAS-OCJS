def solution(n):
    cnt=0
    lmt=0
    while n > 1:
        if n % 6 == 0:
            cnt=cnt+1
            n = n/6
        else:
            if (n*2) % 6 == 0:
                n = (n*2)/6
                cnt=cnt+2
            else:
                n = n*2
                cnt=cnt+1
                lmt=lmt+1
                
            if(lmt>50):
                break

    if n == 1:
        return cnt
    else:
        return '-1'


for _ in range(int(input())):
    n = int(input())
    print(solution(n))