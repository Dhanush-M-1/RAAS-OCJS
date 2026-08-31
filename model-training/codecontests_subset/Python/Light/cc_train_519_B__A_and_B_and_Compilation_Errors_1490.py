n=int(input())
l11=input().split()
l22=input().split()
l33=input().split()
l1=list(map(int,l11))
l2=list(map(int,l22))
l3=list(map(int,l33))
l1.sort()
l2.sort()
l3.sort()
c=d=0
for i in range(n-1):
    if l2[i]!=l1[i]:
        print(l1[i])
        c=1
        break
if c==0:
    print(l1[n-1])
for j in range(n-2):
    if l3[j]!=l2[j]:
        print(l2[j])
        d=1
        break
if d==0:
    print(l2[n-2])
