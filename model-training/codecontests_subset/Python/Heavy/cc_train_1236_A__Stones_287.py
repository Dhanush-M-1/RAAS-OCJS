for _ in range(int(input())):
	l=list(map(int,input().split()))
	ll=[i for i in l]
	ans=0

	a1=0
	x=min(l[2]//2,l[1])
	l[2]-=x*2
	l[1]-=x
	a1+=x+x*2
	y=min(l[1]//2,l[0])
	l[2]-=y*2
	l[1]-=y
	a1+=y+y*2

	a2=0
	x=min(l[1]//2,l[0])
	l[1]-=x*2
	l[0]-=x
	a2+=x+x*2
	y=min(l[2]//2,l[1])
	l[2]-=y*2
	l[1]-=y
	a2+=y+y*2


	# a2=0
	# x=ll[1]//2
	# if(ll[1]>=2*x and ll[0]>=x):
	# 	a2+=x*2+x
	# 	ll[1]-=x*2
	# 	ll[0]-=x
	
	# y=ll[2]//2
	# if(ll[2]>=2*y and ll[1]>=y):
	# 	a2+=y*2+y
	# 	ll[2]-=y*2
	# 	ll[1]-=y

	print(max(a1,a2))
	


