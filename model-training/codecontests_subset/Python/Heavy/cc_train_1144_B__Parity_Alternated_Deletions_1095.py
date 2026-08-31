n = int(input())
x = input().split()
x = [int(i) for i in x]
a=[]
b=[]
a1=[]
b1=[]
suma=[]
j = 0
mini = 0
for i in x:
    if int(i)%2==0:
        b.append(i)
        b1.append(i)
    else:
        a.append(i)
        a1.append(i)
a = sorted(a)
b = sorted(b)
a1 = sorted(a1)
b1 = sorted(b1)
#print(a, b)
j = min(len(a), len(b))
for i in range(j):
        a.pop()
        b.pop()
if(a!=b):
    if(a==[]):
        b.pop()
    if(b==[]):
        a.pop()
#print(a, b)
tmp = sum(a)+sum(b)
mini = tmp
#print(a1, b1)
j = min(len(a1), len(b1))
for i in range(j):
    a1.pop()
    b1.pop()
#print(a1, b1)
tmp = sum(a1)+sum(b1)
if (tmp<mini):
    mini = tmp
print(mini)