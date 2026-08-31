r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
ans = []
a = (r1+c1-d2)//2
ans.append(a)
b = r1 - a
ans.append(b)
c = c1 - a
ans.append(c)
d = d1 - a
ans.append(d)

ans = list(set(ans))
if(len(ans)<4):
    print(-1)
elif(ans[3]>9):
    print(-1)
elif(a*b*c*d <=0):
    print(-1)
elif(max(a,b,c,d)>9):
    print(-1)
elif((c+d)!=r2 or (b+d)!=c2 or (c+b)!=d2):
    print(-1)
else:
    print(a,b)
    print(c,d)