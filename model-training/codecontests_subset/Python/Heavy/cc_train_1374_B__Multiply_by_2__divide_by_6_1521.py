for _ in range(int(input())):
    n = int(input())
    if n==1:
        print("0")
    else:
        a = 0
        b = 0
        check=False
        while n%3==0 or n%2==0:
            if n%3==0:
                a+=1
                n//=3
            elif n%2==0:
                b+=1
                n//=2
            else:
                check=True
                break
        if check or n!=1:
            print("-1")
        else:
            if a-b>=0:
                print(a-b+a)
            else:
                print("-1")