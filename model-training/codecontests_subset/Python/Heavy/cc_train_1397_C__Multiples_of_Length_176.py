from sys import stdin
input=stdin.readline

def A():
    t=int(input())
    for _ in range(t):
        d=[0]*26
        n=int(input())
        for j in range(n):
            for i in input().rstrip():
                d[ord(i)-ord('a')] += 1
        truth = True
        for i in range(26):
            if d[i] % n != 0:
                truth = False
                break
        if truth: print("YES")
        else: print("NO")

def B():
    n=int(input())
    a=sorted(list(map(int,input().split())))
    baseCost=sum(a)-n
    c=2
    cost=0
    while True:
        cost=0
        for i in range(n):
            cost += abs(a[i] - c**i)
        if cost < baseCost:
            c += 1
            baseCost = cost
        else:
            break
    print(baseCost)
        
def C():
    n=int(input())
    a=list(map(int,input().split()))

    if n == 1:
        print(1,1)
        print(-1*a[0])
        print(1,1)
        print(0)
        print(1,1)
        print(0)
        return
    
    k=[((n - 1) - (a[i] % (n - 1))) * n for i in range(n)]
    print(1,n)
    print(*k)
    print(1,1)
    print(-1*(k[0] + a[0]))
    print(2,n)
    print(*[-1*(k[i] + a[i]) for i in range(1,n)])

C()
