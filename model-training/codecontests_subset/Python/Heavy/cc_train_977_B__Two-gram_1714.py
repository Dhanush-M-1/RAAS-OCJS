'''
1374b codeforces
def ans(n,count):
    c=count
    a=0
    if n==1 and c==0:
        return 0
    elif n==1 and c!=0:
        print(c)
        return c
    elif c==100:
        print("hi")
        return -1
    elif n%6==0:
        c+=1
        n=n/6
        a=ans(n,c)
    else:
        n=n*2
        c+=1
        a=ans(n,c)

for x in range(int(input())):
    n=int(input())
    s=0
    s=ans(n,0)
'''
from statistics import  mode
n=int(input())
a=input()
b=[]
i=len(a)
j=0
while j<i:
    if j<=i-2:
        b.append(str(a[j]) + str(a[j + 1]))
    j+=1
s=mode(b)
print(s)