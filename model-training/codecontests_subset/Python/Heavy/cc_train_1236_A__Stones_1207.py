n = int(input())
for i in range(n):
    a,b,c = map(int,input().split())
    count=0
    while (b>=1 and c>=2):
        count+=3
        b-=1
        c-=2
    while (a>=1 and b>=2):
        count+=3
        a-=1
        b-=2

    print(count)

'''q = int(input())
for _ in range(q):
        a, b, c = map(int, input().split(' '))
        ans = 0
        while (b >= 1 and c >= 2):
            ans += 3
            b -= 1
            c -= 2
        while (a >= 1 and b >= 2):
            ans += 3
            a -= 1
            b -= 2
        print(ans)'''




