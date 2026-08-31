from sys import stdin,stdout

q=int(input())

for k in range(q):
	n=int(input())
	l=[]

	for i in range(n):

		d=list(map(int,stdin.readline().split()))
		l.append(d)

	flag=0
	# print(l)

	for i in range(n):

		if i==0:
			if l[i][1]>l[i][0]:
				flag=1
				break

		else:

			d=l[i][1]-l[i-1][1]
			# print(d)

			if l[i][0]-l[i-1][0]<d:
				# print(l[i][0]-l[i-1][0])
				flag=1
				break

			if l[i][0]>=l[i][1] and l[i][0]>=l[i-1][0] and l[i][1]>=l[i-1][1]:
				flag=0

			else:
				flag=1
				break


			


			

	if flag==1:
		print("NO")

	else:
		print("YES")



		# for j in range(2):
