n = int(input())
e1 = list(map(int, input().split()))
e2 = list(map(int, input().split()))
e3 = list(map(int, input().split()))
e1.sort()
e2.sort()
e3.sort()
f=0
for i in range(n-1):
    if e1[i]!=e2[i]:
        print(e1[i])
        f=1
        break
if f==0:
    print(e1[-1])
f=0
for i in range(n-2):
    if e2[i]!=e3[i]:
        print(e2[i])
        f=1
        break
if f==0:
    print(e2[-1])