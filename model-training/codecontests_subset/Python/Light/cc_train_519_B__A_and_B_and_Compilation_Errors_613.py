n=int(input())
x=input()
s1=x.split()
x=input()
s2=x.split()
x=input()
s3=x.split()
s1.sort()
s2.sort()
s3.sort()
m=-1
for i in range(0,len(s1)-1):
	#6print(s1[i],s2[i])
	if s1[i]!=s2[i]:
	    m=i
	    break
if m==-1:
    print(s1[len(s1)-1])
else:
	print(s1[m])
m=-1	    	    	
for i in range(0,len(s2)-1):
	#print(s2[i],s3[i])
	if s2[i]!=s3[i]:
	    m=i
	    break
if m==-1:
    print(s2[len(s2)-1])
else:
	print(s2[m])