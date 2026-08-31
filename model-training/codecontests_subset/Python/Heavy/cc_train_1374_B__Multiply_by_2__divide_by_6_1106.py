import math
for i1 in range(int(input())):
    n=int(input())
    if n==1:
        print(0)
        continue
    three=0
    two=0
    t1=n
    t2=n
    while t1%3==0:
        three+=1
        t1=t1//3
    while t2%2==0:
        two+=1
        t2=t2//2
    #print(three,two)
    
    check=3**three*(2**two)

    #print('Here',check)
    if check!=n:
        print(-1)
        continue
    elif three==two:
        print(three)
        continue
    elif three>two:
        ans=three-two
        print(three+ans)
        continue
    else:
        print(-1)
        continue
        
        
        
        