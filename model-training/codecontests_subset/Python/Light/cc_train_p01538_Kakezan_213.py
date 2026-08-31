def calc(n):
    if n>=10 and n<100:
        return (n//10)*(n%10)
    elif n>=100 and n<1000:
        r1=(n//10)*(n%10)
        r2=(n//100)*(n%100)
        return max(r1,r2)
    elif n>=1000 and n<10000:
        r1=(n//10)*(n%10)
        r2=(n//100)*(n%100)
        r3=(n//1000)*(n%1000)
        return max(r1,r2,r3)
    elif n>=10000 and n<100000:
        r1=(n//10)*(n%10)
        r2=(n//100)*(n%100)
        r3=(n//1000)*(n%1000)
        r4=(n//10000)*(n%10000)
        return max(r1,r2,r3,r4)
    elif n>=100000 and n<1000000:
        r1=(n//10)*(n%10)
        r2=(n//100)*(n%100)
        r3=(n//1000)*(n%1000)
        r4=(n//10000)*(n%10000)
        r5=(n//100000)*(n%100000)
        return max(r1,r2,r3,r4,r5)
    else:
        r1=(n//10)*(n%10)
        r2=(n//100)*(n%100)
        r3=(n//1000)*(n%1000)
        r4=(n//10000)*(n%10000)
        r5=(n//100000)*(n%100000)
        r6=(n//1000000)*(n%1000000)
        return max(r1,r2,r3,r4,r5,r6)
n=int(input())


for i in range(n):
    cnt=0
    a=int(input())
    while a>=10:
        a=calc(a)
        cnt+=1

    print(cnt)

