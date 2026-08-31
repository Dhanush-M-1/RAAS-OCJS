a=int(input())
i=0
while i in range(a):
    b,c,d=map(int,input().split())
    s=c%d
    if s==0 and (b<d or b==d) :
        
        print(c+d)
    elif s!=0 and (b<d or b==d):
        print(c+d-s)
    elif s==0 and b>d :
        print(d)
    elif s!=0 and b>d:
        print(d)
    i+=1
