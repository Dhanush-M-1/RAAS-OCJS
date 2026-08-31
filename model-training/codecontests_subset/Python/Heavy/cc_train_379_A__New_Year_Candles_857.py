'''t=int(input())
for i in range(t):
    n=int(input())
    x=(4*n)-2
    print((x//(n+1)))
    '''
'''n = int(input())
cnt = 1
while n>5:
	cnt+=1
	n-=5
print(cnt)
'''
'''  
s=input()
n = len(s)
fl =0
c = "hello"
cnt = 0
for i in range(n):
	if s[i] == c[cnt]:
		cnt+=1
	if cnt == 5:
		fl = 1
		break
if fl:
	print("YES")
else:
	print("NO")
'''
'''
n = int(input())
l = list(map(int,input().split()))
cnt=1
i =0
m = 1
while i<n-1:
	if l[i]<=l[i+1]:
		cnt+=1
		if cnt>m:
			m = cnt
	else:
		cnt =1
	i+=1
print(m)
'''
'''
n = int(input())
s = input()
s= s.lower()
st= set(s)
if len(st) == 26:
	print("YES")
else:
	print("NO")
'''
x,y = map(int,input().split())
print(x+((x-1)//(y-1)))
