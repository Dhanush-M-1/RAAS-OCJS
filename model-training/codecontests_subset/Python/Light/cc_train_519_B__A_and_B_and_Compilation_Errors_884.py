
n=int(input())
l=input().split(" ",n)
m=input().split(" ",n-1)
j=input().split(" ",n-2)
n1=[]
n2=[]
n3=[]
c=0
sum2=0
sum1=0
sum3=0
for i in range(n):
	sum1 += int(l[i]);
	n1.append(int(l[i]))
for i in range(n-1):
	sum2 +=int(m[i])
	n2.append(int(m[i]))
for i in range(n-2):
	n3.append(int(j[i]))
	sum3 +=int(j[i])
print(sum1-sum2)
print(sum2-sum3)