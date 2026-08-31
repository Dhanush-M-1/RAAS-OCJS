r=[int(i)for i in input().split()]   
c=[int(i)for i in input().split()]  
d=[int(i)for i in input().split()] 
a=(d[0]-r[1]+c[0])//2
b= r[0]-a
y= c[0]-a
z= d[0]-a
if (a>9 or a<=0) or (b>9 or b<=0) or (y>9 or y<=0)  or (z>9 or z<=0) or (a==b) or (a==c)or (a==y) or (a==z) or (z==y) or (z==c) or (b==z)  or (c==y) or (c==b) or (b==y):
   print("-1")
else:
   print(a,b)
   print(y,z)