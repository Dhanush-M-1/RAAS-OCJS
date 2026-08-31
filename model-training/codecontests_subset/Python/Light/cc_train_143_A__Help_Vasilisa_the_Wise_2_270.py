r1, r2 = map(int,input().split())
c1, c2 = map(int,input().split())
d1, d2 = map(int,input().split())
l = []

for i in range(1,c2+1) :
  l.append((c2-i,i))

for i in l : 
  x2,y2 = i
  x1 = r1 - x2
  y1 = c1 - x1

  a = [x1+y1 == c1, x2+y2 == c2, x1+x2 == r1,y1+y2 == r2,
     x1+ y2 == d1, x2 + y1 == d2, len(set([x1,x2,y1,y2])) == 4, 1<=x1 <= 9,1<=y2 <= 9,1<=x2 <= 9,1<=y1 <= 9 ]
  
  if all(a) == True :
    print(x1,x2)
    print(y1,y2)
    exit()

print(-1)
