import math
#n=int(input())
n,m = map(int, input().strip().split(' '))
#lst = list(map(int, input().strip().split(' ')))
if n>m:
    n,m=m,n
if n==m:
    print(0)
else:
    p2=0
    p3=0
    p5=0
    p22=0
    p33=0
    p55=0
    while(True):
        if m%2==0:
            p2+=1
            m=m//2
        elif m%3==0:
            p3+=1
            m=m//3
        elif m%5==0:
            p5+=1
            m=m//5
        else:
            break
    while(True):
        if n%2==0:
            p22+=1
            n=n//2
        elif n%3==0:
            p33+=1
            n=n//3
        elif n%5==0:
            p55+=1
            n=n//5
        else:
            break
    if n!=1 or m!=1:
        if m%n!=0:
            print(-1)
        else:
            k1=m//n
            if math.log10(k1)/ math.log10(2) % 1 == 0 or math.log10(k1)/ math.log10(5) % 1 == 0 or math.log10(k1)/ math.log10(3) % 1 == 0:
                if math.log10(k1)/ math.log10(2) % 1 == 0:
                    print(abs(p2-p22)+abs(p5-p55)+abs(p3-p33)+int(math.log10(k1)/ math.log10(2)))
                elif math.log10(k1)/ math.log10(3) % 1 == 0:
                    print(abs(p2-p22)+abs(p5-p55)+abs(p3-p33)+int(math.log10(k1)/ math.log10(3)))
                elif math.log10(k1)/ math.log10(5) % 1 == 0:
                    print(abs(p2-p22)+abs(p5-p55)+abs(p3-p33)+int(math.log10(k1)/ math.log10(5)))
            else:
                print(-1)
    else:
        print(abs(p2-p22)+abs(p5-p55)+abs(p3-p33))
        
            
    
