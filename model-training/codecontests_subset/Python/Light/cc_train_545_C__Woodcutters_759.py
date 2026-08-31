n = int(input())
				
a = [[ int(x) for x in input().split()] for i in range(n)]

if  len(a) > 1 :
	k = 2
	d_left = a[1][0] - a[0][0]
	l =0
	for i in range(1,n-1) :
		if (l== 0 and (a[i][1] < (a[i][0] - a[i-1][0]))) or (a[i][1]< d_left and  l==1)  :
			k+=1
			d_left = a[i+1][0] - a[i][0]
			l=0
		elif a[i][1] < (a[i+1][0] - a[i][0]) :
			k+= 1
			d_left = (a[i+1][0] - a[i][0]) -a[i][1]
			l =1
		else :
			l =0
			d_left =(a[i+1][0] - a[i][0]) -a[i][1]



	print(k)
else :
	print(len(a))
			

	


