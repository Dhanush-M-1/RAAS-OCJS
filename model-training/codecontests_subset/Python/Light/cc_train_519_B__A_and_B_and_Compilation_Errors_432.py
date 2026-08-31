n=int(input())
a=input().split()
a.sort()
a1=input().split()
a1.sort()
for i in range(len(a1)):
    if a[i]!=a1[i]:
        print(a[i])
        break
else:
    print(a[-1])
a2=input().split()
a2.sort()
for i in range(len(a2)):
    if a1[i]!=a2[i]:
        print(a1[i])
        break
else:
    print(a1[-1])