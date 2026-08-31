r=[int(x) for x in input().split()]
c=[int(x) for x in input().split()]
d=[int(x) for x in input().split()]

w=(d[0]-r[1]+c[0])//2
x=r[0]-w
y=c[0]-w
z=d[0]-w
if 1<=w<=9 and 1<=x<=9 and 1<=y<=9 and 1<=z<=9 and w!=x and w!=y and w!=z and x!=y and x!=z and y!=z:
  print(w,x)
  print(y,z)
else:
  print(-1)
