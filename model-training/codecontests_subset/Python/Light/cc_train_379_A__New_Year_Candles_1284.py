a,b=[int(i)for i in input().split()]
n=0
n+=a
resi=a%b
c=int((a-resi)/b)
while c>=1:
    n+=c
    a=c+resi
    resi=a%b
    c=int((a-resi)/b)
print(n)
