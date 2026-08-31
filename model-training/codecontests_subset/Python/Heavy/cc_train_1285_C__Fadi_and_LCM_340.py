import math
x = int(input())
if x==1:
    print(1,"",1)
else:
    i = int(math.sqrt(x))
    if i*i==x:
        i-=1

    flag=0
    while flag==0:
        if i>int(x/i):
            larger=i
            smaller=int(x/i)
        else:
            larger=int(x/i)
            smaller=i
        
        if smaller==1:
            print(i,"",int(x/i))
            flag=1
            break
        else:
            if x%i==0 and math.gcd(larger,smaller)==1:
                print(i,"",int(x/i))
                flag=1
                break
        i-=1