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

a = list(map(int,input().split('+')))
a.sort()
print('+'.join([str(c) for c in a]))
