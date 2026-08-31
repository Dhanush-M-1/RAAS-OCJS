import itertools
# n, m = map(int, input().split())
# l = list(map(int, input().split()))
# l.sort()
# listfinal=[]
# k=[]
# for i in range(len(l)+1):
# i = 0
# while i < len(l):
#     if l[i]==l[i+1]:
#         k.append(l[i])
#         l.pop(l[i])
# print(k)
# print(l)
# for i in range(len(l)):
#     if l[i-1]!=l[i]:
#         listfinal.append(l[i])
# print(listfinal)
# a=m*[0]
# for i in range(n):
#     a[l[i]-1]+=1
# s=0
# for i in range(m-1):
#     for j in a[i+1:m]:
#         s+=a[i]*j
# list(itertools.combinations(range(len(l)), 2))
# list = [(l[i],l[j]) for i in range(len(l)) for j in range(i+1, len(l))]
# count = 0
# # for i in range(len(list)):
# #     if list[i+1]!=list[i]:
# #         count+=1
# #         # list.pop(i)
# #         listfinal.append(list[i])
# # print((list))
# print(listfinal)
# print(count)


n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(set(a))

ans = 0

for i in range(m - 1):
    for j in range(i + 1, m):
        ans += a.count(b[i]) * a.count(b[j])

print(ans)

