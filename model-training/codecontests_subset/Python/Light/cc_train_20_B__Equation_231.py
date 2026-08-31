a,b,c=list(map(float,input().split()))
if a==0 and b==0 and c==0: print(-1)
elif a==0 and b==0 and c!=0: print(0)
elif a==0: 
    print(1)
    print(-c/b)
elif b*b-4*a*c<0: print(0)
else:
    a1,a2=(-b+(b*b-a*4*c)**0.5)/(2*a),(-b-(b*b-a*4*c)**0.5)/(2*a)
    if a1==a2:
        print(1)
        print('{0:.5f}'.format(a1))
    else: 
        print(2)
        print('{0:.6f}'.format(min(a1,a2)))
        print('{0:.6f}'.format(max(a1,a2)))