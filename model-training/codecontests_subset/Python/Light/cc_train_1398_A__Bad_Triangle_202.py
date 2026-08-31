# for _ in range(int(input())):
#     s = input()
#     z = []
#     c = 0
#     for i in range(len(s)):
#         if s[i]=="1":
#             c+=1
#         else:
#             if c:
#                 z.append(c)
#             c=0
#     if c:
#         z.append(c)
#     z.sort(reverse=True)
#     su = 0
#     if z:
#         for i in range(0,len(z),2):
#             su+= z[i]
#
#     print(su)


for _ in range(int(input())):
    n = int(input())
    l = list(map(int, input().rstrip().split(" ")))

    if l[1]+l[0] <= l[-1]:
        print(1,2,n)
    else:
        print(-1)

