for _ in range(int(input())):
	s,t=input().split()
	n=len(s)
	m=len(t)
	cnt=[0]*255
	for i in s:
		cnt[ord(i)]+=1
	for i in range(n):
		if i==m:
			s="---"
			break
		elif s[i]<t[i]:
			break
		else:
			if s[i]>t[i]:
				cnt[ord(s[i])]-=1
				for j in list(range(ord(t[i])-1,50,-1))+[ord(t[i])]:
					if cnt[j]>=1:
						for k in range(n-1,i,-1):
							if s[k]==chr(j):
								s=s[:i]+chr(j)+s[i+1:k]+s[i]+s[k+1:]
								break
						break
				else:
					s="---"
				break
			else:
				cnt[ord(s[i])]-=1
				for j in range(ord(t[i])-1,50,-1):
					if cnt[j]>=1:
						for k in range(n-1,i,-1):
							if s[k]==chr(j):
								s=s[:i]+chr(j)+s[i+1:k]+s[i]+s[k+1:]
								break
						break
				else:
					continue
				break
			print(s)
	if s>=t:
		s="---"
	print(s)