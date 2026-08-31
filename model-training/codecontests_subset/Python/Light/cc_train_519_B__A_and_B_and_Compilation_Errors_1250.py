I = lambda : map(int, input().split())
_ = input()
l = list(I())
l2 = list(I())
l3 = list(I())

l.sort()
l2.sort()
l3.sort()


result1 = ""
for i in range(len(l)-1):
    if(l[i] != l2[i]):
        result1 = l[i]
        break

if(result1 == ""):
    result1 = l[-1]

result2 = ""
for i in range(len(l2)-1):
    if(l2[i] != l3[i]):
        result2 = l2[i]
        break

if(result2 == ""):
    result2 = l2[-1]

print(result1)
print(result2)
