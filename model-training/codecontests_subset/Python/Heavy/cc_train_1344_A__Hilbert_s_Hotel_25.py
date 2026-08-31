"Codeforces Round #639 (Div. 2)"
"A. Puzzle Pieces"
# y=int(input())
# ans=[]
# for i in range(y):
#     al=input().split()
#     m = list(map(int, al))
#     n=min(m[0],m[1])
#     k=max(m[1],m[0])
#     if n!=1 and k>2:
#         ans.append("NO")
#     elif n>1 and k>1:
#         ans.append('YES')
#     elif n==1:
#         ans.append("YES")        

# for i in ans:
#     print(i)        
"B. Card Constructions"
# y=int(input())
# ans=[]
# for i in range(y):
#     n=int(input())
#     a=0
#     j=1
#     t=[0]
#     f=0
#     if n<2:
#         ans.append(0)
#         continue
#     while True:
#         t.append(int((j*(j+1))+((j*(j-1))/2)))
#         #print(t,j,t[j],n)
#         f=int((j*(j+1))+((j*(j-1))/2))
#         j+=1
#         if f>n:
#             break
#     n=n-t[-2]
#     a+=1
#     j=1
#     #print(n,a)
#     while n>1:
#         if t[j]>n:
#             #print(n,t[j-1],a+1)
#             n=n-t[j-1]
#             a+=1
#             j=1
#         j+=1
#     ans.append(a)        
            
# for i in ans:
#     print(i) 
"C. Hilbert's Hotel"
y=int(input())
ans=[]
for i in range(y):
    n=int(input())
    al=input().split()
    m = list(map(int, al))
    s=[]
    for j in range(n):
        s.append(j)
        m[j]=((j+m[j]%n)+n)%n
        # if m[j]>-1:
        #     m[j]=m[j]%n
        # else:
        #     m[j]=n-((-1*m[j])%n)
    if set(s)==set(m):
        ans.append("YES")
    else:
        ans.append("NO")            
for i in ans:
    print(i) 
