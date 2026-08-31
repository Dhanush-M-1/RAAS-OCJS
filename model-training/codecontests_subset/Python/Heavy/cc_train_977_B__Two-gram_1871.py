'''
#		SHREYANS BHAVSAR	#
#       DDIT				#
#       @shreyans_9950		#
#       CF,CC,HE,HR,GFG		#
'''

# import math
# def shrey():
	# /*!@#$%^&*()-+=*/
	# s=list(input())
	# l=len(s)
	# ans=""
	# for i in range(l):
	# 	if(i==0 or i==l-1 or i%2!=0):
	# 		ans+=s[i]

	# print(ans)
	# n=int(input())
	# a=list(map(int,input().split()))
	# c=0
	# c1=0
	# for i in range(len(a)):
	# 	if(i%2==0 and  a[i]%2!=0):
	# 		c+=1
	# 	if(i%2!=0 and a[i]%2==0):
	# 		c1+=1
	# if(c!=c1):
	# 	print(-1)
	# else:
	# 	print(c)
	# a,b=input().split()
	# a=int(a)
	# b=int(b)
	# ans=(60-b)+((23-a)*60)
	# print(ans)
	# n,k=input().split()
	# n=int(n)
	# k=int(k)
	# print(n-max(0,n%k-k//2))
	# n,k=input().split()
	# n=int(n)
	# k=int(k)
	# for i in range(k):
	# 	if(n%10!=0):
	# 		n-=1
	# 	else:
	# 		n=n//10
	# print(n)

# T = input()
# T = int(T)
# for q in range(1,T+1):
	# /*shreyans bhavsar(DDIT)*/
	# shrey()
n = int(input())
str1 = input()
lst1 = []
for i in range(n-1):
    lst1.append(str1[i:i+2])
 
print (max(lst1,key=lst1.count))