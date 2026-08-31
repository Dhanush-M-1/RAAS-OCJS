r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
a=(r1+c1-d2)/2
b=r1-a;c=c1-a;d=d1-a
A=set()
A.add(a);A.add(b);A.add(c);A.add(d)
if(a>9 or b>9 or c>9 or d>9):
    print("-1")
elif(a<1 or c<1 or b<1 or d<1):
    print("-1")
elif(a!=int(a)):
    print("-1")
elif(len(A)<4):
    print("-1")
elif(a+b!=r1 or c+d !=r2 or a+c !=c1 or b+d!=c2 or a+d!=d1 or b+c !=d2):
    print("-1")
else:
    print(int(a),int(b))
    print(int(c),int(d))