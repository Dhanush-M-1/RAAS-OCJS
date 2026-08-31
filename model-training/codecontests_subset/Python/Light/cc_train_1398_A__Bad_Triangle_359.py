from sys import stdin,stdout

# stdin  = open("input.txt","r")
# stdout = open("output.txt","w")

t = int(stdin.readline().strip())

for _ in range(t):
	n = int(stdin.readline().strip())
	narr = list(map(int,stdin.readline().strip().split(' ')))

	if n==3:
		arr=narr
		if arr[0]+arr[1]<=arr[2]:
			stdout.write(str(1)+" "+str(2)+" "+str(3)+"\n")
		else:
			stdout.write("-1\n")
	else:
		arr=[narr[0],narr[1],narr[-1]]
		if arr[0]+arr[1]<=arr[2]:
			stdout.write(str(1)+" "+str(2)+" "+str(n)+"\n")
		else:
			stdout.write("-1\n")