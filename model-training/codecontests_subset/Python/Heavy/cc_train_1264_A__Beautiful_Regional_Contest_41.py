from collections import Counter
for nt in range(int(input())):
	n=int(input())
	p=list(map(int,input().split()))
	if n<8:
		print (0,0,0)
	else:
		if p[n//2]==p[n//2-1]:
			num = p[n//2]
			l=[]
			for i in p:
				if i!=num:
					l.append(i)
				else:
					break
		else:
			l=p[0:n//2]
		if len(l)==0:
			print (0,0,0)
			continue
		c=[]
		count=1
		for i in range(1,len(l)):
			if l[i]==l[i-1]:
				count+=1
			else:
				c.append([l[i-1],count])
				count=1
		c.append([l[-1],count])
		if len(c)<3:
			print (0,0,0)
		else:
			g=c[0][1]
			s,b=0,0
			for i in range(1,len(c)):
				if s<=g:
					s+=c[i][1]
				else:
					b+=c[i][1]
			if g<s and g<b:
				print (g,s,b)
			else:
				print (0,0,0)
