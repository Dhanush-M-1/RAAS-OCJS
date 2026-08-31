import math 
for _ in range(int(input())):
    n=int(input())

    if n%3!=0 and n!=1:
        print('-1')
    elif n==1:
        print('0')
    else:
        two=0
        three=0
        flag=True

        while n>1:
            if n%6==0:
                n=n//6
                three+=1
                two+=1
            elif n%3==0:
                n=n//3
                three+=1
            elif n%2==0:
                n=n//2
                two+=1
            else:
                print('-1')
                flag=False
                break

        if two>three and flag:
            print("-1")
        elif flag:
            res=abs(two-three)+max(two,three)
            print(res)
        

    

