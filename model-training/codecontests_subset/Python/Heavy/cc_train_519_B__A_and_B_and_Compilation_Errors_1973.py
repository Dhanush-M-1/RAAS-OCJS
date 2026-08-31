n=int(input())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]
#n=int(input("enter the initial no of errors"))
'''for i in range(n):
    a.append(int(input("enter compiler error no in the first list")))
for i in range(n-1):
    b.append(int(input("enter compiler error no in the second list")))
for i in range(n-2):
    c.append(int(input("enter compiler error no in the third list")))'''

a.sort()
b.sort()
c.sort() 
for i in range(n-1):
    if b[i]!=a[i]:
        print(a[i])
        break
    elif (i == n-2) and (b[i]==a[i]):
        print(a[i+1])
for i in range(n-2):
    if c[i]!=b[i]:
        print(b[i])
        break
    elif (i==n-3) and (c[i]==b[i]):
        print(b[i+1])

