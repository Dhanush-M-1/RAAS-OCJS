n=int(input())
mn=list(map(int, input().split()))
mn1=list(map(int, input().split()))
mn2=list(map(int, input().split()))
mn.sort()
mn1.sort()
mn2.sort()
q=w=0
for ind, item in enumerate(mn1):
    if item!=mn[ind]:
        print (mn[ind])
        q=5
        break
if q!=5:
    print (mn[len(mn)-1])
for ind, item in enumerate(mn2):
    if item!=mn1[ind]:
        print (mn1[ind])
        w=5
        break
if w!=5:
    print (mn1[len(mn1)-1])