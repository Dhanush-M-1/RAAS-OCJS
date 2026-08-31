n=int(input())
l=list(map(int,input().split()))
l.sort()
l1=list(map(int,input().split()))
l1.sort()
l2=list(map(int,input().split()))
l2.sort()
for i in range(n-1):
    if l[i]!=l1[i]:
        print(l[i])
        break
else:
    print(l[-1])
for i in range(n-2):
    if l1[i]!=l2[i]:
        print(l1[i])
        break
else:
    print(l1[-1])