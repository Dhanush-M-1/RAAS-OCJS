
r = list(map(int,input().split()))
c = list(map(int,input().split()))
d = list(map(int,input().split()))

b = (d[0]-r[0]+c[1])//2
a = r[1]-b
x = c[0]-a
y = r[0]-x
l = [x,y,a,b]

if len(list(dict.fromkeys([x,y,a,b])))==4:
	if min(l)>0 and max(l)<10:
		print(x,y,'\n'+str(a),b)
	else:
		print(-1)
else:
	print(-1)

