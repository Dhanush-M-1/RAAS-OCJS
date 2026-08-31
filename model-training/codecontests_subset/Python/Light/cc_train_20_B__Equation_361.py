R=lambda:map(int,input().split())
(a,b,c) = R()
if b:
	t  = [1,-c/b]
else:
	t = [-(c==0)]
if a:
	(d,x) = ((b*b)-(4*a*c),-2*a)
	if d: 
		if d < 0:
			t = [0]  
		else:
			t = [2] + sorted([(b - d ** 0.5) / x, (b + d ** 0.5)/x])
	else:
		t = [1,b/x]
if len(t)==1:
	print(*t)
elif len(t)==2:
	print(t[0])
	print('%.10f'%t[1])
else:
	print(t[0])
	print('%.10f'%t[1])
	print('%.10f'%t[2])