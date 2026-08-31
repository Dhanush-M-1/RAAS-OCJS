n = int(input())
errors = list(map(int, input().split()))
error1 = list(map(int, input().split()))
error2 = list(map(int, input().split()))

errors.sort()
error1.sort()
error2.sort()
e1 = -1
e2 = -1
found = False
for i in range(0,n-1):
    if(errors[i]!=error1[i]):
        e1 = errors[i]
        found = True
        break
if(found==False):
    e1 = errors[n-1]
found = False
for i in range(0,n-2):
    if(error1[i]!=error2[i]):
        e2 = error1[i]
        found = True
        break
if(found==False):
    e2 = error1[n-2]
print(e1)
print(e2)


