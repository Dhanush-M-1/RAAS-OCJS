n,m = map(int,input().split())
array = list(map(int,input().split()))
flag = 0;

greater = [];
smaller = [];
ptr1 = 0;
ptr2 = 0;

if n==1:
	print(abs(array[0]-m))
else:

	for i in range(n):

		if array[i] < m:
			smaller.append(m-array[i])
			ptr2+=1;
		elif array[i]>m:
			greater.append(array[i]-m)
			ptr1+=1;
		else:
			flag+=1;

	if flag>1:

		while(flag!=1):
			greater.append(0);
			ptr1+=1;
			flag-=1;

	greater.sort();
	smaller.sort();
	ans=0;
	j=0;
	#print(ptr1,ptr2)
	if ptr2>ptr1:
		while(ptr2 != n//2):
			ptr1+=1;
			ptr2-=1;
			ans += smaller[j]
			j+=1;
	elif ptr2<ptr1:
		while(ptr1 != n//2):
			ptr1-=1;
			ptr2+=1;
			ans += greater[j]
			j+=1;

	print(ans)

