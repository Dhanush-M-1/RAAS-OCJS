a, b = map(int, input().split())
if a==b:
    print(0)
else:
    a2,a3,a5 = 0,0,0
    b2,b3,b5 = 0,0,0
    while True:
        if a%2==0:
            a2+=1
            a/=2
        elif a%3==0:
            a3+=1
            a/=3
        elif a%5==0:
            a5+=1
            a/=5
        else:
            break
    while True:
        if b%2==0:
            b2+=1
            b/=2
        elif b%3==0:
            b3+=1
            b/=3
        elif b%5==0:
            b5+=1
            b/=5
        else:
            break
    if a!=b:
        print(-1)
    else:
        print(abs(a2-b2)+abs(a3-b3)+abs(a5-b5))