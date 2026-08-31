a,b,c=map(int,input().split())

dis=b*b-4*(a)*(c)
if(a==0):
    if(b==0):
        if(c==0):
            print(-1)
        else:
            print(0)
    else:
        print(1)
        print(-c/b)
else:
    if(dis==0):
        print(1)
        print((-b+dis**(0.5))/(2*a))
    else:
        if(dis<0):
            print(0)
        else:
            print(2)
            print(min((-b - dis ** 0.5) / (2 * a), (-b + dis ** 0.5) / (2 * a)))
            print(max((-b - dis ** 0.5) / (2 * a), (-b + dis ** 0.5) / (2 * a)))
        
