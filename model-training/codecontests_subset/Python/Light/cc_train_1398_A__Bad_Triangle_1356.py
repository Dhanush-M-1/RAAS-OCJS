num = int(input())
for n in range(num):
    num2 = int(input())
    lis = list(map(int,input().split()))
    lis2 = lis[:]
    a = lis.index(min(lis))
    numa = lis.pop(a)
    b = lis.index(min(lis))
    numb = lis.pop(b)
    ch = True
    for i in lis2:
        if numa + numb <= i:
            print(1,2,lis2.index(i)+1)
            ch = False
            break
    if ch:
        print(-1)