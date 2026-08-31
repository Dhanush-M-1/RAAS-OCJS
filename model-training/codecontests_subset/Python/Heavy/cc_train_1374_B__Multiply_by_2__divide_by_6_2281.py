import string
t = int(input())
for _ in range(t):
    n = int(input())
#    n = 10**(9)
    if n==1:
        print(0)
        continue
    s = str(n)
    
    ans = 0
    for j in s:
        j = int(j)
        ans+=j
    if ans%3!=0:
        print(-1)
        continue
    count2=0
    count3=0
    x = n
    tmp=0
    while x==int(x) and x!=1:
        if x%2==0:
            count2+=1
            x//=2
        elif x%3==0:
            count3+=1
            x//=3
        else:
            print(-1)
            tmp=1
            break
    if tmp==1:
        continue
    if count2==count3:
        print(count3)
    elif count2>count3:
        print(-1)
    else:
        print((2*count3)-count2)