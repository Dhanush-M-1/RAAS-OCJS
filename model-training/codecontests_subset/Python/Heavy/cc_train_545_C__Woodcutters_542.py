'''input
5
1 2
2 1
5 10
10 9
20 1	
'''
from sys import stdin,stdout
import bisect
I = lambda: stdin.readline().strip()
read =   lambda: map(int,stdin.readline().split())

n = int(I())
arr = [tuple(read()) for i in range(n)]
arr.sort()
# print(arr)
last_occupied = -10**9
count = 0
n1 = n-1
for ind,i in enumerate(arr):
	x,r = i
	if x-r>last_occupied:
		last_occupied = x
		count += 1
	elif ind==n1 or arr[ind+1][0]>x+r:
		last_occupied = x+r
		count += 1
	else:
		last_occupied = x

print(count)
quit()

#180C
s = I()
min_so_far = track = sum([i.upper()==i for i in s])#count no of upper case 

for i in s:
	track += [-1,1][i.lower()==i]# if we split at char i into (upper ,lower)
	min_so_far = min(min_so_far,track)
print(min_so_far)

quit()
len_s = len(s)
tempu,templ = 0,0
dpu,dpl = [0]*(len_s+1), [0]*(len_s+1)
for ind,i in enumerate(s):
	if i==i.lower():
		tempu+=1
	dpu[ind+1] = tempu
for i in range(len(s)-1,-1,-1):
	if s[i]==s[i].upper():
		templ+=1
	dpl[i] = templ
# print(dpl,dpu)

print(min([dpu[x]+dpl[x+1] for x in range(len_s)]))
quit()
#550A
s = I()
x = s.find('AB')
if x>-1:
	if s[x+2:].find('BA')>-1:
		print('YES')
		quit()
x = s.find('BA')
# print(x,s[x+2:].find('AB'))
if x>-1:
	if s[x+2:].find('AB')>-1:
		print('YES')
		quit()
print('NO')
quit()
#987C
n = int(I())
s = tuple(read())
c = tuple(read())

INF = 10**9
min_so_far = INF
for j in range(n):
	m1 = min([INF]+[c[i] for i in range(j) if s[i]<s[j]])
	m2 = min([INF]+[c[i] for i in range(j+1,n) if s[i]>s[j]])
	min_so_far = min(min_so_far,c[j]+m1+m2)
print(min_so_far if min_so_far<INF else -1)

quit() 
#289B
n,m,d = read()
arr = []
for i in range(n):
	arr.extend(list(read()))

base = arr[0]
for i in arr:
	if (i-base)%d:
		print(-1)
		quit()

arr.sort()
s = n*m
Sum = 0
dev1 = dev2 = 0
if s%2:
	median = arr[s//2]
	for i in arr:
		Sum+=abs(i-median)
else:
	m1,m2 = arr[(s//2)-1],arr[s//2]
	Sum2 = 0
	for i in arr:
		Sum+=abs(i-m1)
		Sum2+=abs(i-m2)
	Sum = min(Sum,Sum2)
print(Sum//d)
