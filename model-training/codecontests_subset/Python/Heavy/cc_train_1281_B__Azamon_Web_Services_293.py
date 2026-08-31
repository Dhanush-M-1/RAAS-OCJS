q=int(input())
def func(l,smallest,s1,s2):
	i=0
	while i<l:
		if s1[i]==s2[i]:
			if smallest[i]!=-1:
				s1[i],s1[smallest[i]]=s1[smallest[i]],s1[i]
				if s1<s2:
					print("".join(s1))
					return
				else:
					s1[i],s1[smallest[i]]=s1[smallest[i]],s1[i]
		else:
			if smallest[i]!=-1:
				s1[i],s1[smallest[i]]=s1[smallest[i]],s1[i]
				if s1<s2:
					print("".join(s1))
				else:
					print("---")
			else:
				print("---")
			return
		i+=1
	print("---")
	return

def func2(smallest,s1,s2):
	for i in range(len(s1)):
		# if smallest[i]!=-1:
		s1[i],s1[smallest[i]]=s1[smallest[i]],s1[i]
		if s1<s2:
			print("".join(s1))
			return
		s1[i],s1[smallest[i]]=s1[smallest[i]],s1[i]
	print("---")

for x in range(q):
	s1,s2=map(str,input().split())
	s1=[x for x in s1]
	s2=[x for x in s2]
	l=min(len(s1),len(s2))
	if s1<s2:
		print("".join(s1))
	else:
		smallest=[len(s1)-1 for x in range(len(s1))]
		x=len(s1)-2
		small=x+1
		while x>=0:
			if s1[x]<s1[small]:
				small=x
				smallest[x]=small
			else:
				smallest[x]=small
			x-=1
		# func(l,smallest,s1,s2)
		func2(smallest,s1,s2)