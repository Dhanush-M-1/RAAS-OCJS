import math
'''A=int(input())
B=int(input())
if A%2==0:
	a=A
else:
	a=A+1
if B%2==0:
	b=B
else:
	b=B+1
print(int((a-b)/2))'''
'''a=int(input())
b=int(input())
c=int(input())
d=[a,b,c]
def qsort1(list):
    if list == []: 
        return []
    else:
        pivot = list[0]
        lesser = qsort1([x for x in list[1:] if x < pivot])
        greater = qsort1([x for x in list[1:] if x >= pivot])
        return lesser + [pivot] + greater
d=qsort1(d)
print(d[1])'''
'''a=int(input())
nums=[]
for i in range(1,a+1):
	if a% i==0 and (math.sqrt(i)).is_integer():
		nums.append(i)
print(nums[-1])'''
'''n=int(input())
a='-++-'
b='--+'
if n%4 == 0:
	print(a*int(n//4))
if n% 4 == 3:
	print(b+(a*int(n//4)))
else:
	print("IMPOSSIBLE")'''
'''s = input()
svet = ['N','W','E','S']
ch =''
ns = 0
we = 0
for i in range(len(s)):
    if s[i] not in svet:
        ch += s[i]
    else:
        if s[i] == 'N':
            ns += int(ch)
        if s[i] == 'S':
            ns -= int(ch)
        if s[i] == 'W':
            we -= int(ch)
        if s[i] == 'E':
            we += int(ch)
        ch = ''
 
print(abs(ns), 'N' if ns > 0 else 'S', abs(we), 'E' if we > 0 else 'W', sep='')'''
'''n,m = map(int,input().split())
a=n*m
b=[]
c=[]
s=0
for i in range (n):
	i=input().split()
	if len(i)>m:
		break
	else:
		b.append(i)
z=input()
for i in range (n):
	i=input().split()
	if len(i)>m:
		break
	else:
		c.append(i)
for i in range(n):
	for j in range(m):
		if b[i][j]==c[i][j]:
			s+=1'''
'''otv=open('buildingin.txt').read().splitlines()
n=int(otv[0][0])
k=int(otv[0][2])
x=int(otv[0][4])
y=int(otv[0][6])
q=int(otv[1])
g=otv[2]
a=g.split()
for i in range(len(a)):
	a[i]=int(a[i])'''
'''x1=int(input())
y1=int(input())
x2=int(input())
y2=int(input())
x=int(input())
y=int(input())
x3=x1
y3=y2
x4=x2
y4=y1
b=[x,y]
c=[[x,y]]
a = [[x1,y1],[x2,y2],[x3,y3],[x4,y4]]
for i in range(len(a)-1):
	if b[0]-a[i][0]and b[1]-a[i][1]>b[0]-a[i+1][0]and b[1]-a[i+1][1]:
		c.pop(0)
		c.append(i)
print(c)'''
'''m,n,a=map(int,input().split())
s=m//a
k=n//a
if m%a != 0:
	s+=1
if n%a !=0:
	k+=1
g=s*k
print(g)'''

'''n=int(input())
for i in range(n):
	a=input()
	if len(a)>10:
		f=a[0]
		h=len(a)-2
		end=a[len(a)-1]
		print(f+str(h)+end)
	else:
		print(a)'''
'''n,k=map(int,input().split())
a=list(map(int, input().split(maxsplit=n)))
s=0
for i in a:
	if i>0:
		if i >= a[k-1]:
			s+=1
print(s)'''
'''a=input().lower()
b=["a","e","o","u","y","i"]
a=filter(lambda x: x not in b,a)
a=".".join(a)
print("."+a)'''
'''n=int(input())
b=[]
c=[1]
s=0
for i in range(n):
	a=input().split()
	b.append(a)
for i in range(len(b)):
	print(b)
	b[i]=list(filter(lambda x: x in c,b[i]))
	print(b[i])
	if len(b[i])>=2:
		s+=1
print(s)'''
'''a=int(input())
b=0
c=0
while b<a:
	if input().count("1")>1:
		c+=1
	b+=1
print(c)'''
'''m,n=list(map(int,input().split()))
e=m*n
w=2*1
print(e//w)'''
'''n=int(input())
x=0
b=[]
for i in range(n):
	a=input()
	b.append(a)
for i in b:
	if i == "X++" or i== "++X":
		x+=1
	if i == "--X" or i=="X--":
		x-=1
print(x)'''
'''a=input()
b=input()
a=a.lower()
b=b.lower()
if a>b:
	print(1)
elif b>a:
	print(-1)
else:
	print(0)'''
'''a=input()
if a.find("1111111") != -1 or a.find("0000000") !=-1:
	print("YES")
else:
	print("NO")'''
a=input()
a=a.replace("+","")
b=[]
for i in a:
	b.append(i)
b.sort()
b=''.join(b)
b="+".join(b)
print(b)