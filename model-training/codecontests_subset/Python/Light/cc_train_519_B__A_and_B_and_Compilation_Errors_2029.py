n=int(input())
data=[]
for i in range(3):
    s=[int(a) for a in input().split()]
    data.append(s)
s1=sum(data[0])-sum(data[1])
s2=sum(data[1])-sum(data[2])
print(s1)
print(s2)
