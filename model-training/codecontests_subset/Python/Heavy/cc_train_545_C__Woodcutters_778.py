"C. Woodcutters"
y=int(input())
c=[]
h=[]
s=[]
for i in range(y):
    al=input().split()
    m = list(map(int, al))
    c.append(m[0])
    h.append(m[1])
if y<2:
    max=y
else:
    max=2
s.append(-1)
for i in range(1,y-1):
    if (c[i]-c[i-1]>h[i]) and s[i-1]<1:
        s.append(-1)
        max+=1
    elif (c[i]-c[i-1]-h[i-1]>h[i]) and s[i-1]==1:
        s.append(-1)
        max+=1
    elif (c[i+1]-c[i]>h[i]):
        s.append(1)
        max+=1
    else:
        s.append(0)
s.append(1)
# print(max)
# print(c,h,s)
# c=c[::-1]
# h=h[::-1]
# max1=2
# s1=[]
# s1.append(1)
# for i in range(y-2,0,-1):
#     if (c[i-1]-c[i]>h[i]) and s1[3-i]>-1:
#         s1.append(1)
#         max1+=1
#     elif (c[i]-c[i+1]>h[i]):
#         s1.append(-1)
#         max1+=1
#     else:
#         s1.append(0)
# s1.append(-1)
# # print(max1)
# # print(c,h,s1)
# if max1>max:
#     max=max1
print(max)
