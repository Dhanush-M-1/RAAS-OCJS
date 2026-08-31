t=int(input())
if 1<=t<=1000:
	for i in range(t):
		n,m=map(int,input().split())
		if 1<=n<=1000 and 1<=m<=1000:
			a=list(map(int,input().split()))
			b=list(map(int,input().split()))
			if len(a)==n and len(b)==m:
				for x in a:
					if 1<=x<=1000:
						continue
					else:
						exit()
				for x in b:
					if 1<=x<=1000:
						continue
					else:
						exit()
				set1=set(a)
				set2=set(b)
				com=set1.intersection(set2)
				com=list(com)
				if len(com)!=0:
					print("YES")
					print("1",com[0])
				else:
					print("NO")
			else:
				exit()
		else:
			exit()
else:
	exit()