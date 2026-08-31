m = int(input())

lst=[int(i) for i in input().split()]
lst1=[int(i) for i in input().split()]
lst2 =[int(i) for i in input().split()]

a=0
b=0
c=0
for i in range(0,m):
    a = a+lst[i]
    if(i<m-1):
        b=b+lst1[i]
    if(i<m-2):
        c=c+lst2[i]
print(a-b)
print(b-c)