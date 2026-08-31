# n=int(input())
# if(n%2==0):
#     print("YES")
# else:
#     print("NO")
# for _ in range(int(input())):
#     n=(input())
#     if(len(n)<=10):
#         print(n)
#     else:
#         print(n[0]+str(len(n)-2)+n[len(n)-1])
# a=0
# for _ in range(int(input())):
#     n=list(map(int,input().split()))
#     count=0
    
#     for i in range(len(n)):
#         if(n[i]==1):
#             count+=1
#         else:
#             count-=1
#     if(count>0):
#         a+=1
# print(a)
# n,m=map(int,input().split())
# a=list(map(int,input().split()))
# count=0
# for i in range(len(a)):
#     if(a[i]>=a[m-1] and a[i]>0):
#         count+=1
# print(count)
# n,m=map(int,input().split())
# # if((n*m)%2!=0):
# print((n*m)//2)
# # else:
# #     print((n*m)//2)\
# x=0
# for _ in range(int(input())):
#     n=input()
#     if(n=="X++" or n=="++X"):
#         x=x+1
#     else:
#         x=x-1
# print(x)
# n = input()
# m = input()
# n = n.lower()
# m = m.lower()
# if n == m:
#     print("0")
# elif n > m:
#     print('1')
# elif n <m:
#     print('-1')
# matrix=[]
# min=[]
# one_line=0
# one_column=0
# for l in range(0,5):
#     m=input().split()
#     for col,ele in enumerate()

# a = list(map(int,input().split('+')))
# a.sort()
# print('+'.join([str(c) for c in a]))
# n=list(input())
# # if(n[0].islower()):
#     n[0]=n[0].upper()
# else:
#     pass
# print("".join(str(x)for x in n))
# n=list(input())
# s=input()
# count=0
# for i in range(1,len(s)):
#     if(s[i]==s[i-1]):
#         count+=1
# print(count)
# v=["A","O","Y","E","U","I","a","i","e","o","u","y"]
# n=list(input())
# x=[]
# for i in range(len(n)):
#     if n[i] not in v:
#         x.append(n[i])
# print("."+".".join(str(y.lower())for y in x))
# a=[]
# b=[]
# c=[]
# for _ in range(int(input())):
#     x,y,z=map(int,input().split())
#     a.append(x)
#     b.append(y)
#     c.append(z)
# print("YES" if sum(a)==sum(b)==sum(c)== 0 else "NO") 
# m = "hello"
# n=input()
# j=0
# flag=0
# for i in range(len(n)):
#     if(n[i]==m[j]):
#         j=j+1
#     if(j==5):
#         flag=1
#         break
# if(flag==1):
#     print("YES")
# else:
#     print("NO")
# a=set(list(input()))
# print("CHAT WITH HER!" if len(set(list(input())))%2==0 else "IGNORE HIM!")
# k,n,w=map(int,input().split())
# sum=0
# a=[]
# for i in range(w+1):
#     sum+=k*i
# print((sum-n) if sum>n else 0)
# m,n = 0,0
# for i in range(5):
# 	a = map(int,input().split())
# 	for j in range(5):
# 		if a[j]!=0:
# 			m = i
# 			n = j
# 			break
# print(abs(m-2)+abs(n-2))
# l,b=map(int,input().split())
# c=0
# while(l<=b):
# 	l=l*3
# 	b=b*2
# 	c=c+1
# print(c)
# from math import ceil 
# n,m,a=map(int,input().split()) 
# # print(ceil(n/a),ceil(m/a))
# c=ceil(n/a)*ceil(m/a)  
# print(c) 
# n=int(input())
# if(n%4==0 or n%7==0 or n%44==0 or n%47==0 or n%74==0 or n%444==0 or n%447==0 or n%474==0 or n%477==0):
# 	print("YES")
# else:
# 	print("NO")
# def tramCapacity():
#     n = int(input().strip())
#     pout, pin = map(int, input().strip().split())
#     sm = pin
#     mx = pin
#     for i in range(n-1):
#         pout, pin = map(int, input().strip().split())
#         sm = sm - pout + pin
#         if sm > mx:
#             mx = sm
#     return mx

# print(tramCapacity())
# n,k=map(int,input().split())
# for i in range(k):
# 	if(str(n)[-1]=="0"):
# 		n=n//10
# 	else:
# 		n=n-1
# print(n)
# n=int(input())
# n=int(input())
# if(n%5==0):
# 	print(n//5)
# else:
# 	print((n//5)+1)
# n=int(input())
# if(n%2==0):
#     print(n//2)
# else:
#     print("-"+str(n-((n-1)//2)))
# n=int(input())
# arr=list(map(int,input().split()))
# sum=sum(arr)
# deno=len(arr)*100
# print(format(((sum/deno)*100),'.12f'))
# k=int(input())
# l=int(input())
# m=int(input())
# n=int(input())
# d=int(input())
# count=0
# # if(d%k==0):
# #     print(d)
# # elif(d%l==0):
# #     print(d//l)
# # elif(d%m==0):
# #     print(d//m)
# # elif(d%n==0):
# #     print(d//n)
# # else:
# for i in range(1,d+1):
#     if(i%k==0 or i%l==0 or i%m==0 or i%n==0):
#         count+=1
# print(count)

# a,b=map(int,input().split())
# # if(n%m==0):
# #     print(0)    
# # else:
# #     for i in range(m):
# #         n=n+i
# #         if(n%m==0):
# #             print(i-1)
# #             break
# #         else:
# #             continue
# x=((a+b)-1)/b
# print((b*x)-1)
# for _ in range(int(input())):
#     a, b = map(int,input().split(" "))
#     x=(a + b - 1) // b
#     # print(x)
#     print((b * x) - a)
# for _ in range(int(input())):
#     n=int(input())
#     print((n-1)//2)
# n=int(input())
# # n = int(input())
# if n%2 == 0:
#     print(8, n-8)
# else:
#     print(9, n-9)
# n=int(input())
# a=[]
# for i in range(len(n)):
#     x=int(n)-int(n)%(10**i)
#     a.append(x)
# print(a)
# # b=max(a)
# print(a[-1])
# for i in range(len(a)):
#     a[i]=a[i]-a[-1]
# print(a)
# for _ in range(int(input())):
#     n=int(input())
#     p=1
#     rl=[]
#     x=[]
#     while(n>0):
#         dig=n%10
#         r=dig*p
#         rl.append(r)
#         p*=10
#         n=n//10
#     for i in rl:
#         if i !=0:
#             x.append(i)
#     print(len(x))
#     print(" ".join(str(x)for x in x))
# n,m=map(int,input().split())
# print(str(min(n,m))+" "+str((max(n,m)-min(n,m))//2))
# arr=sorted(list(map(int,input().split())))
# s=max(arr)
# ac=arr[0]
# ab=arr[1]
# bc=arr[2]
# a=s-bc
# b=ab-a
# c=bc-b
# print(a,b,c)
# x=0
# q,t=map(int,input().split())
# for i in range(1,q+1):
#     x=x+5*i
#     if(x>240-t):
#         print(i-1)
#         break
# if(x<=240-t):
#     print(q)       
# # print(q)
# print(z)
# print(x)
# l=(240-t)-x
# print(l)
# if(((240-t)-x)>=0):
#     print(q)
# else:
#     print(q-1)
# n, L = map(int, input().split())
# arr = [int(x) for x in input().split()]
# arr.sort()

# x = arr[0] - 0
# y = L - arr[-1]

# r = max(x, y) * 2

# for i in range(1, n):
#     r = max(r, arr[i] - arr[i-1])

# print(format(r/2,'.12f'))

# n,m=map(int,input().split())
# print(((m-n)*2)-1)
# for _ in range(int(input())):
#     n=int(input())
#     x=360/(180-n)
#     # print(x)
#     if(n==60 or n==90 or n==120 or n==108 or n==128.57 or n==135 or n==140 or n==144 or n==162 or n==180):
#         print("YES")
#     elif(x==round(x)):
#         print("YES")
#     else:
#         print("NO")
# n,m=map(int,input().split())
# if(n<2 and m==10):
#     print(-1)
# else:
#     x=10**(n-1)
#     print(x+(m-(x%m)))
# for _ in range(int(input())):
#     n,k=map(int,input().split())
#     a=list(map(int,input().split()))
#     a.sort()
#     c=0
#     for i in range(1,n):
#         c = (k-a[i])//a[0]
# #         print(c)
# for _ in range(int(input())):
#     x,y=map(int,input().split())
#     a,b=map(int,input().split())
#     q=a*(x+y)
#     p=b*(min(x,y))+a*(abs(x-y))
#     print(min(p,q))
# n,k=map(int,input().split())
# a=n//2+n%2
# print(a)
# if(k<=a):
#     print(2*k-1)
# else:
#     print(2*(k-a))
# a,b=map(int,input().split())
# count=0
# if(a>=b):
#     print(a-b)
# else:
#     while(b>a):
#         if(b%2==0):
#             b=int(b/2)
#             count+=1
#         else:
#             b+=1
#             count+=1
#     print(count+(a-b))
# n=int(input())
# while n>5:
#     n = n - 4
#     n=(n-((n-4)%2))/2
# # print(n)
# if n==1:
# 	print('Sheldon')
# if n==2:
# 	print('Leonard')
# if n==3:
# 	print('Penny') 
# if n==4:
# 	print('Rajesh')
# if n==5:
#     print('Howard')
# n, m = (int(x) for x in input().split())
# if(n<m):
#     print(-1)
# else:
#     print((int((n-0.5)/(2*m))+1)*m)
# for _ in range(int(input())):
#     n,k=map(int,input().split())
#     print(k//n)
#     print(k%n)
#     if((k+(k//n))%n==0):
#         print(k+(k//n)+1)
#     else:
#         print(k+(k//n))
# for i in range(int(input())):
#     n,k=map(int,input().split())
#     print((k-1)//(n-1) +k)
# for _ in range(int(input())):
#     n,k = map(int,input().split())
#     if (n >= k*k and n % 2 == k % 2):
#         print("YES")
#     else:
#         print("NO")
# for _ in range(int(input())):
#     n,x=map(int,input().split())
#     a=list(map(int,input().split()))
#     arr=[]
#     # s=sum([i%2 for i in a])
#     for i in a:
#             j=i%2
#             arr.append(j)
#     s=sum(arr)
#     # print(s)
#     if s==0 or (n==x and s%2==0) or (s==n and x%2==0):
#         print("No")
#     else:
#         print("Yes")
# a=int(input())
# print(a*(a*a+5)//6)

# n,m=map(int,input().split())
# a=[]
# k='YES'
# for i in range(m): 
#     a.append(list(map(int,input().split())))
# a.sort()
# for i in a:
#     if i[0]<n:
#         n=n+i[1]
#     else:
#         k='NO'
#         break
# print(k)

# a=input()
# if('1'*7 in a or '0'*7 in a):
#     print("YES")
# else:
#     print("NO")


# s=int(input())
# for i in range(s):
#     n=int(input())
#     if (n//2)%2==1:
#         print('NO')
#     else:
#         print('YES')
#         for j in range(n//2):
#             print(2*(j+1))
#         for j in range(n//2-1):
#             print(2*(j+1)-1)
#         print(n-1+n//2)
# k,r=map(int,input().split())
# i=1

# while((k*i)%10)!=0 and ((k*i)%10)!=r:
#     i=i+1
# print(i)
# for _ in range(int(input())):
#     n,m=map(int,input().split())
#     if(abs(n-m)==0):
#         print(0)
#     else:
#         if(abs(n-m)%10==0):
#             print((abs(n-m)//10))
#         else:
#             print((abs(n-m)//10)+1)
# a,b,c=map(int,input().split())
# print(max(a,b,c)-min(a,b,c))
# a=int(input())
# arr=list(map(int,input().split()))
# print(a*max(arr)-sum(arr))

# for _ in range(int(input())):
#     a, b = map(int, input().split())
#     if a==b:
#         print((a+b)**2)
#     elif max(a,b)%min(a,b)==0:
#         print(max(a,b)**2)
#     else:
#         ans=max(max(a,b),2*min(a,b))
#         print(ans**2)
# import math
# # for _ in range(int(input())):
# x=int(input())
# a=list(map(int,input().split()))
# for j in range(len(a)):
#     n=math.sqrt(a[j])
#     flag=0
#     if(a[j]==1):
#         print("NO")
#     elif(n==math.floor(n)):
#         for i in range(int(n)):
#             if((6*i)-1==n or ((6*i)+1==n) or n==2 or n==3 or n!=1):
#                     # print("YES")
#                 flag=1
#                 break
#             else:
#                 flag=0
#         print("YES" if flag==1 else "NO")
#     else:
#         print("NO")
# print(12339-12345)
# for _ in range(int(input())):
#     x,y,n=map(int,input().split())
#     # for i in range((n-x),n):
#     #     # if(i%x==y):
#     #     print(i)
#     print(n-(n-y)%x)
# n=int(input())
# for _ in range(int(input())):
# 	n= int(input())
# 	print(int(2**(n//2+1)-2))
# for _ in range(int(input())):
#   n=int(input())  
#   arr=list(map(int,input().split()))
#   countod=0
#   countev=0
#   for i in range(n):
#     if i%2==0 and arr[i]%2!=0:
#       countev+=1
#     elif i%2!=0 and arr[i]%2==0:
#       countod+=1
#   if countod!=countev:
#     print(-1)
#   else:
#     print(countev)
# n,m=map(int,input().split())
# x=m/(n//2)
# print(x)
# print(int(x*(n-1)))
# for _ in range(int(input())):
#     n,m = map(int,input().split())
#     print(m*min(2,n-1))
# n=int(input())
# if(n%2==0):
#     print(n//2)
#     print('2 '*(n//2))
# else:
#     print(((n-2)//2)+1)
#     print('2 '*(((n-2)//2)) + "3") 
# for _ in range(int(input())):
#     n=int(input())
#     for i in range(2,30):
#         if(n%(2**i - 1)==0):
#             print(n//(2**i - 1))
#             break
# a,b=map(int,input().split())
# print((a-1)//(b-1)+a)
# for _ in range(int(input())):
#     n=int(input())
#     print(n//2)
# for _ in range(int(input())):
#     n=int(input())
#     if(n%2==0):
#         print(n//2)
#     else:
#         print((n//2)+1)
# for _ in range(int(input())):
#     a,b = map(int, input().split())
#     count = 0
#     while(min(a,b) != 0):
#         x=max(a,b)
#         y = min(a,b)
#         a = y
#         b=x
#         count += b//a
#         b = b % a
#     print(count)
# n,k=map(int,input().split())
# a=list(map(int,input().split()))
# m=min(a)
# c=0
# for i in a:
#     if (i-m)%k!=0:
#         print(-1)
#         break
#     c+=(i-m)//k
# else:
#     print(c)

# a,b = map(int,input().split())
# l = b-(2*a)
# if l < a:
# 	print(a-l)
# else:
# 	print(0)
for _ in range(int(input())):
    n = int(input())
    n2 = 0
    n3 = 0
    while n % 2 == 0:
        n2 += 1
        n //= 2
    while n % 3 == 0:
        n3 += 1
        n //= 3
    if n != 1 or n2 > n3:
        print(-1)
    else:
        print(2 * n3 - n2)