n = int(input())
l = list(map(int,input().split()))
l2=sorted(l)
l.sort()
l.reverse()
if l[0]%2 == 0:
    flag = 1;f2 = 1
else:
    flag = 0;f2 = 0
l.pop(0);k = 0
while len(l)!=0:
    if l[k]%2 == flag:
        l.pop(k)
        flag = (flag+1)%2
        k = 0
        continue
    k+=1
    if k == len(l):
        break
s1=sum(l)
###############
k = 0
while len(l2)!=0:
    if l2[k]%2 == f2:
        l2.pop(k)
        f2 = (f2+1)%2
        k = 0
        continue
    k+=1
    if k == len(l2):
        break
s2 = sum(l2)
print(min(s1,s2))


