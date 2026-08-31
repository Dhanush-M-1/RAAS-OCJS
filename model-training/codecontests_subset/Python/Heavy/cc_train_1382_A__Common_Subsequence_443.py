


# k=int(input())
# l=int(input())
# m=int(input())
# n=int(input())
# d=int(input())
#
# count=d
#
# if k ==1 or l==1 or m==1 or n ==1:
#     print(d)
# else:
#     for i in range(1,d+1):
#         if i%k!=0 and i%l!=0 and i%m!=0 and i%n!=0:
#             count-=1
#     print(count)











t=int(input())
for t in range(t):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))[:n]
    b=list(map(int,input().split()))[:m]
    l=list(set(a).intersection(set(b)))
    if len(l)!=0:
        print("YES")
        print(1,l[0])
    else:
        print("NO")


# for _ in range(int(input())):
# 	_ = input()
# 	a = set(map(int, input().split()))
# 	b = set(map(int, input().split()))
# 	c = a.intersection(b)
# 	if c:
# 		print('YES')
# 		print('1 ' + str(list(c)[0]))
# 	else:
# 		print('NO')
    # flag=0


    # for i in range(n):
    #     for j in range(m):
    #         if a[i]==b[i]:
    #             l.append(a[i])
    #             flag=1
    #             break
    #     if flag==1:
    #         break
    # if flag==0:
    #     print("NO")
    # else:
    #     print(len(l),str(l))








