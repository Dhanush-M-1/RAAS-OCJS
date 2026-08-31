import sys
s=input()
count1=0
count2=0
count3=0
for i in range(0,len(s)):
	if(s[i]=='1'):
		count1+=1
	if(s[i]=='2'):
		count2+=1
	if(s[i]=='3'):
		count3+=1
flag=0
if(len(s)==1):
	print(s)
	flag=1
if(flag==0):
	s1=""
	temp=count1
	while(count1>0):
		s1+="1+"
		count1-=1

	#print('dekh '+s1)
	s1=s1.rstrip('+')
	#print('baad '+s1)
	if((count2>0 or count3>0) ):
		if(temp>0):
			#print('asdsas')
			s1+="+"

	temp1=count2
	while(count2>0):
		s1+="2+"
		count2-=1
	s1=s1.rstrip('+')
	if(count3>0):
		if(temp+temp1>0):
			#print("dekho")
			s1+="+"

	while(count3>0):
		s1+="3+"
		count3-=1
	s1=s1.rstrip('+')

	print(s1)