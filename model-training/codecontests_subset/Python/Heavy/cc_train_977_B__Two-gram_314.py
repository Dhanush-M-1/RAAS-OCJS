# import numpy 

# def count(n1,st):
#     n=0
#     s={}
#     s=numpy.zeros(n1-1)
#     result=0
#     ans=""

#     while n<n1-1:
#         aux=st[n:n+2]
#         k=0
#         l=0
#         print(aux)

#         for k in range(n):
#             if st[k:k+2] == aux:
#                 s[k]+=1
#                 break

#             if s[k]>=result:
#                 result=s[k]
#                 ans=st[k:k+2]
#             k+=1

#         n+=1

#     print("=======")
#     print(ans)

n1=int(input())
s = input()
lis = []
count = []
Max=0

for i in range(n1):
    lis.append(s[i:i+2])
    count.append(0)
    
for j in range(n1):
    for i in range(n1-1):
        if lis[j]==s[i:i+2]:
            count[j]+=1
            if count[j]>Max:
                Max=count[j]
                ans=lis[j]

print(ans)