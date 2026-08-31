n=int(input())
p=input()
a=[]
for i in range(n):
  a.append(int(p[i]))
x=a.count(8)
y=(len(a))//11
print(min(x,y))