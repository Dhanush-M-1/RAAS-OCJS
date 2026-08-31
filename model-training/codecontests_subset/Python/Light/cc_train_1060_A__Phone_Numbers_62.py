n=int(input())
s=str(input())
k=0
for i in range (n) :
    if int(s[i])==8 :
        k=k+1
l=n/11
if (k > 0 and l>0):
    if (l>k):
        p=k
    else :
        p=l
else:
    p=0
p=int(p)
print(p)