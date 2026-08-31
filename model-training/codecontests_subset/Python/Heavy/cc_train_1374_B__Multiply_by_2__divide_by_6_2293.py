def solve():
    n=int(input())
    num3=0
    num2=0
    ans=0
    if n==1:
        print(0)
        return
    while n>1:
        notdiv=False
        if n%3==0:
            n//=3
            num3+=1
            notdiv=True
        if n%2==0:
            n//=2
            num2+=1
            notdiv=True
        if not notdiv:
            print(-1)
            return
    if num3<num2:
        print(-1)
        return
    while num2<num3:
        n*=2
        num2+=1
        ans+=1
    ans+=num3
    print(ans)

t=int(input())
for _ in range(t):
    solve()
