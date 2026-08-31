for _ in range (int(input())):
    n=int(input())
    a = [int(i) for i in input().split()]
    m = n//2
    num = []
    count=1
    if n!=1:
        for i in range (m-1,-1,-1):
            if a[i]==a[m]:
                m-=1
            else:
                break
    for i in range (m-2,-1,-1):
        if a[i]==a[i+1]:
            count+=1
        else:
            num.append(count)
            count=1
    if count!=0:
        num.append(count)
    temp = 0
    if len(num)<3:
        temp = 1
    gold = num[-1]
    rem = sum(num)-gold
    num.pop()
    silver=0
    for i in range(len(num)-1,0,-1):
        silver+=num[i]
        num.pop()
        if silver>gold:
            break
    bronze=0
    for i in range(len(num)-1,-1,-1):
        bronze+=num[i]
        num.pop()
    if bronze<=gold or silver<=gold:
        temp = 1
    if temp==1:
        print(0,0,0)
    else:
        print(gold,silver,bronze)