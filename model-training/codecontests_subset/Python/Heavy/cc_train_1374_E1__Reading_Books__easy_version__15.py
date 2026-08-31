from sys import stdin,stdout

# stdin = open("input.txt","r")
# stdout = open("output.txt","w")




n,k = stdin.readline().strip().split(' ')
n,k = int(n),int(k)

books=[]

for i in range(n):
	t,a,b=stdin.readline().strip().split(' ')
	t,a,b=int(t),int(a),int(b)
	books.append((t,a,b))

pairs_a=[]
pairs_b=[]
single=[]

for i in books:
	if i[1]==1 and i[2]==1:
		single.append(i[0])
	elif i[1] or i[2]==1:
		if i[1]==1:
			pairs_a.append(i[0])
		else:
			pairs_b.append(i[0])

pairs_b=sorted(pairs_b)
pairs_a=sorted(pairs_a)
# print(single)
# print(pairs_a)
# print(pairs_b)
pairs=[]
for i in range(min(len(pairs_a),len(pairs_b))):
	single.append(pairs_a[i]+pairs_b[i])

single=sorted(single)

if len(single)<k:
	stdout.write(str(-1)+"\n")
else:
	stdout.write(str(sum(single[:k]))+"\n")




