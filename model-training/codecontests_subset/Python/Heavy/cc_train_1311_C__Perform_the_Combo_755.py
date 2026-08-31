# for _ in range(int(input())):
#     s,d=map(int,input().split())
#     if s>d:
#         s,d=d,s
#     x=min(s,d//2)
#     if s%3==1:
#         if s==d:
#             y=(s//3)*2
#         else:
#             y=(s//3)*2+1
#     elif s%3==2:
#         y=(s//3)*2+1
#     else:
#         y=(s//3)*2
        
#     print(max(x,y))

# for _ in range(int(input())):
#     n,x,m=map(int,input().split())
#     s=set()
#     s.add(x)
#     for __ in range(m):
#         l,r=map(int,input().split())
#         for i in s:
#             if i>=l and i<=r:
#                 break
#         else:
#             continue
#         for i in range(l,r+1):
#             s.add(i)
#     print(len(s))

for _ in range(int(input())):
    n,m=map(int,input().split())
    s=input()
    lis=list(map(int,input().split()))
    lis.append(n)
    x=[]
    for i in range(n):
        x.append([0]*26)
    
    x[0][ord(s[0])-97]+=1
    j=1
    for i in range(1,n):
        x[j]=x[j-1].copy()
        x[j][ord(s[i])-97]+=1
        j+=1
    res=[0]*26
    for i in lis:
        for j in range(26):
            res[j]+=x[i-1][j]
    print(*res)


    

