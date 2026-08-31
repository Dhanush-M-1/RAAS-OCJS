for _ in range(int(input())):
    n=int(input())
    if n==1:
        print(0)
    else:
        count=0
        while n%3==0:
            n//=3 
            count+=1
        if count==0:
            print(-1)
        else:
            count2=0
            while n%2==0:
                n//=2
                count2+=1
            if count2>count:
            	print(-1)
            elif n!=1:
                print(-1)
            elif count2==count:
                print(count)
            else:
                print(2*count-count2)