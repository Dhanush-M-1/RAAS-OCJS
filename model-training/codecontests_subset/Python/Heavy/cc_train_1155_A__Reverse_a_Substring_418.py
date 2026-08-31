"""for i in range(int(input())):
	N,T=map(int,input().split(" "))
	count=0
	lst=list(map(int,input().split(" ")))

	dicti={}
	store=0

	for i in lst:
		if i in dicti:
			dicti[i]+=1
		else:
			dicti[i]=1

		if i*2==T:
			store=i

	count+=(dicti[store]*(dicti[store]-1))/2
#	print(dicti)

	tmp=[]

	for m in dicti.keys():
		tmp.append(m)

#	print(tmp)

	for i in range(len(tmp)):
		for j in range(i+1,len(tmp)):
			if tmp[i]>=T:
				break
			elif tmp[j]>=T:
				continue

			if tmp[i]+tmp[j]==T:
				count+=dicti[tmp[i]]*dicti[tmp[j]]
				#print(tmp[i],tmp[j],count)

print(int(count))
"""

"""
def rec_fun(sumi,index):
	global min_possible
	
	if index==N-1:
		if sumi<min_possible:
			min_possible=sumi
	for i in range(1,K+1):
		if i+index>=N or sumi>min_possible:
			break
		else:
			rec_fun(sumi+A_list[index+i],index+i)


from math import log10,pow,ceil

N,K=map(int,input().split())
A_list=list(map(log10,map(int,input().split())))

min_possible=sum(A_list)

rec_fun(A_list[0],0)

print(round(pow(10,min_possible))%1000000007)

class div(object):
	def __init__(self,no5,no2):
		self.no2 = no2
		self.no5 = no5

	def __add__(self,toadd):
		return(div(self.no5+toadd.no5,self.no2+toadd.no2))
	
a=[]
ans=[[]]
path=[[]]

def rec(divObj,i,j,N,pathi):
	zeros=min(divObj.no5,divObj.no2)

	if ans[i][j]!=-1 and zeros<ans[i][j]:
		ans[i][j]=zeros
		path[i][j]=pathi
	elif ans[i][j]==-1:
		ans[i][j]=zeros
		path[i][j]=pathi
	else:
		return

	if j+1<N:
		rec(divObj+a[i][j+1],i,j+1,N,pathi+"R")

	if i+1<N:
		rec(divObj+a[i+1][j],i+1,j,N,pathi+"D")

N=int(input())

for i in range(N):
	a.append(list(map(int,input().split())))

for i in range(N):
	for j in range(N):
		temp=a[i][j]

		a[i][j]=div(0,0)

		br1=temp

		while True:
			br1=br1/5
			if br1%1==0:
				a[i][j].no5+=1
			else:
				break

		br2=temp

		while True:
			br2=br2/2
			if br2%1==0:
				a[i][j].no2+=1
			else:
				break

ans = [[-1 for i in range(N)] for j in range(N)]
path = [["" for i in range(N)] for j in range(N)]

rec(a[0][0],0,0,N,"")

#print(ans)
#print(path)

print(ans[N-1][N-1])
print(path[N-1][N-1])




def Tee():
	chars=[0 for i in range(26)]
	chars_temp1=[]

	S=input()

	for i in range(26):
		chars[i]=S.count(chr(65+i))

		if chars[i]>0:
			chars_temp1.append(chars[i])

	length=len(chars_temp1)
	sumi=sum(chars_temp1)
	prev=-1
	i=length

	if max(chars_temp1)==min(chars_temp1):
		print(0)
		return

	chars_temp2=chars_temp1[:]

	while i>0:
#		print(i)
		positive_temp1=0
		negative_temp1=0
		positive_temp2=0
		negative_temp2=0

		if(sumi%i==0):
			store=sumi//i
			for j in range(i):
				if store - chars_temp1[j]>0:
					positive_temp1+=store - chars_temp1[j]
				else:
					negative_temp1+=chars_temp1[j] - store
				
				if store - chars_temp2[j]>0:
					positive_temp2+=store - chars_temp2[j]
				else:
					negative_temp2+=chars_temp2[j] - store
			
			current1=max(positive_temp1,negative_temp1)
			current2=max(positive_temp2,negative_temp2)
			current=min(current1,current2)
			
			i-=1
			if current<prev or prev==-1:
				prev=current

				if i>0:
					minimum=min(chars_temp1)
					maximum=max(chars_temp2)

					index_of_minimum=chars_temp1.index(minimum)
					index_of_maximum=chars_temp2.index(maximum)
					del chars_temp1[index_of_minimum]
					del chars_temp2[index_of_maximum]
				else:
					break
		else:
			i-=1
			if i<=0:
				break
				
			minimum=min(chars_temp1)
			maximum=max(chars_temp2)

			index_of_minimum=chars_temp1.index(minimum)
			index_of_maximum=chars_temp2.index(maximum)
			del chars_temp1[index_of_minimum]
			del chars_temp2[index_of_maximum]


	print(prev)

for i in range(int(input())):
	Tee()


"""

"""
for i in range(int(input())):
	N,D=map(int,input().split(" "))
	Arr=list(map(int,input().split(" ")))

	start=Arr[0]
	flag=False
	Arr.sort()

	st_index=Arr.index(start)


	temp_diff=[0]
	for j in range(1,N):
		if(Arr[j]-Arr[j-1]>D):
			flag=True
			break
		temp_diff.append(Arr[j]-Arr[j-1])

	if(flag):
		print("NO")
		continue

	p=start
	flag=False
	while p>0:
		val_pos=Arr[p]-D
		p_temp=p-1
		while (p_temp>0 and Arr[p_temp-1]>val_pos):	
			p_temp-=1"""


"""n,q=map(int,input().split(" "))
Arr=list(map(int,input().split(" ")))

for i in range(q):
	low,high=map(int,input().split(" "))
	start=0
	end=n-1

	while end>start:
		mid=start+(end-start)//2
		print(start,mid,end)
		if((start==0 and Arr[start]>=low) or (Arr[mid]>=low and Arr[mid-1]<low)):
			break
		elif low>Arr[mid]:
			start=mid+1
		else:
			end=mid-1

	print(mid)"""
"""import atexit, io, sys 
  
# A stream implementation using an in-memory bytes  
# buffer. It inherits BufferedIOBase. 


for i in range(int(input())):
	n,m,k=map(int,input().split(" "))
	Arr=[[0 for i in range(m)] for i in range(n)]
	for i in range(k):
		p,q=map(int,input().split(" "))
		Arr[p-1][q-1]=1

	ans=0
	for i in range(n):
		streak=0
		streak_arr=[]
		for j in range(m):
			if(Arr[i][j]==1):
				streak+=1
			elif(streak>0):
				streak_arr.append(streak)
				streak=0
		if(streak>0):
			streak_arr.append(streak)

		ans+=2*(sum(streak_arr)+len(streak_arr))
	#	print(ans,streak_arr)
	streak=0
	for i in range(1,n):
		for j in range(m):
			if(Arr[i][j]==1 and Arr[i-1][j]==1):
				streak+=1

	ans-=2*streak
	print(ans)


from sys import stdout,stdin
from copy import deepcopy

ans=0
to_sub=0
streak=1
for i in range(int(stdin.readline())):
	n,m,k=map(int,stdin.readline().split(" "))
	prev_p=1
	prev_q=-1
	prev_dict={}
	curr_dict={}
	for i in range(k):
		p,q=map(int,stdin.readline().split(" "))
		print(p,q,prev_dict,curr_dict,prev_p,prev_q)
		if(prev_p==p):
			curr_dict[q]=1
		elif(prev_p+1==p):
			prev_dict=deepcopy(curr_dict)
			curr_dict={}
		else:
			prev_dict={}
			curr_dict={}

		try:
			print(p)
			if(p!=1):
				prev_dict[q]
				to_sub+=1
		except:
			sa=1

		if(prev_p==p and prev_q==prev_q+1):
			streak+=1
		else:
			ans+=2*streak+2
			streak=1

		prev_q=q
		prev_p=p
	print(p,q,prev_dict,curr_dict,prev_p,prev_q)
	if(streak>0):
		ans+=2*streak+2

	print(ans-2*to_sub)


    ans=0
    for i in range(n):
        streak=0
        streak_arr=[]
        for j in range(m):
            if(Arr[i][j]==1):
                streak+=1
            elif(streak>0):
                streak_arr.append(streak)
                streak=0
        if(streak>0):
            streak_arr.append(streak)

        ans+=2*(sum(streak_arr)+len(streak_arr))
    #   print(ans,streak_arr)
    streak=0
    for i in range(1,n):
        for j in range(m):
            if(Arr[i][j]==1 and Arr[i-1][j]==1):
                streak+=1

    ans-=2*streak
    print(ans)
"""


"""
from sys import stdin
for j in range(int(input())):
	n,d=map(int,input().split(" "))
	A=list(map(int,stdin.readline().split(" ")))
	length=len(A)
	
#	first=gcd(,A[1])

	if A[0] > A[1]: 
		small = A[1] 
	else: 
		small = A[0] 
	for i in range(1, small+1): 
		if((A[0] % i == 0) and (A[1] % i == 0)): 
			first = i  

	Ans_Arr=[A[0]//first]
	Arr=[A[0]//first]
	for i in range(length):
		div=A[i]//Arr[-1];
		Arr.append(div)
		if(div not in Ans_Arr):
			Ans_Arr.append(div)
			if(len(Ans_Arr)==26):
				break
		first=div

	Ans_Arr.sort()
	dicti={}
	for i in range(26):
		dicti[Ans_Arr[i]]=chr(i+65)

	print("Case #"+str(j+1)+": ",end="")
	for i in Arr:
		print(dicti[i],end="")
	print()
	


def Tee():
	N=int(input())
	arr=list(map(int,input().split()))
	count=0

	for i in range(N-1,0,-1):
		for j in range(i):
			if arr[i]<arr[j]:
				count+=1

	print(count)

for i in range(int(input())):
	Tee()"""

"""
n,k=map(int,input().split(" "))
Arr=list(map(int,input().split(" ")))

new_Arr=Arr[:]
new_Arr.sort()

dicti={}

chosen=[]

for i in range(n):
	dicti[Arr[i]]=i
	chosen.append(False)
	
for i in range(n):
	"""
"""
count=0

def rec(n,streak,Prokhar):
	#print(n,streak,Prokhar)
	global count
	if n==0:
		count+=1
		return

	if(Prokhar):
		if streak!=A:
			rec(n-1,streak+1,True)
		rec(n-1,1,False)
	else:
		if streak!=B:
			rec(n-1,streak+1,False)
		rec(n-1,1,True)

N,A,B=map(int,input().split())
rec(N-1,1,True)
rec(N-1,1,False)

print(count)"""
"""

def s(X,Y):
	m=len(X)
	n=len(Y)

	L=[[0]*(n+1) for i in range(m+1)]

	for i in range(1,m+1):
		for j in range(1,n+1):
			if(X[i-1]==Y[j-1]):
				print(X[i-1],end="")
				L[i][j]=1+L[i-1][j-1]
			else:
				L[i][j]=max(L[i-1][j],L[i][j-1])

	print(L)

s("MAUSI","MADHOSHI")"""

flag=True
n=int(input())
stri=list(map(ord,list(input())))
for i in range(1,n):
	if(stri[i-1]>stri[i]):
		print("YES")
		print(i,i+1)
		flag=False
		break
if(flag):
	print("NO")