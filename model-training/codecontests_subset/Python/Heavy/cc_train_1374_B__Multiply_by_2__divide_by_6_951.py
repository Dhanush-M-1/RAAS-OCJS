def helper(n):
    steps=0
    step1=0
    if n==1:
        print(0)
        return
    if n<6 and n!=3:
        print(-1)
        return
    else:
        while n%6==0:
            n=n//6
            steps+=1
        if n==1:
            print(steps)
            return
        else:
            while n%3==0:
                n=n//3
                step1+=1
            if n==1:
                print(steps + 2*step1)
                return
    print(-1)

for _ in range(int(input())):
    n=int(input())
    helper(n)
    
