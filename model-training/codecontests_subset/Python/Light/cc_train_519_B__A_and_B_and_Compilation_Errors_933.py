from collections import Counter as c
input()
a=c(input().split())
b=c(input().split())
d=c(input().split())
for i in a.keys():
    if b[i]<a[i]:
        print(i)
        break
for i in b.keys():
    if d[i]<b[i]:
        print(i)
        break
