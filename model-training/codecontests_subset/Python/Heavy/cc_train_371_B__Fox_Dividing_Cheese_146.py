import math
def find_fac_2_3_5(n) :
    pow_2=0
    pow_3=0
    pow_5=0
    #print(n)
    while n%2==0 :
        n=n//2
        pow_2+=1
    while n%3==0 :
        n=n//3
        pow_3+=1
    while n%5==0 :
        n=n//5
        pow_5+=1
    
    
    return pow_2,pow_3,pow_5,n
    
a,b=input().split(" ")
a=int(a)
b=int(b)
k=math.gcd(a,b)
q1,q2,q3,n1=find_fac_2_3_5(a)
e1,e2,e3,n2=find_fac_2_3_5(b)

if a==b :
    print("0")
else :
    if n1==n2 :
        k=math.gcd(a//n1,b//n2)
        w1=a//n1
        w2=b//n2
        x1,x2,x3,t=find_fac_2_3_5(w1//k)
        y1,y2,y3,j=find_fac_2_3_5(w2//k)
        print(x1+x2+x3+y1+y2+y3)

    else :
        print("-1")




    





        