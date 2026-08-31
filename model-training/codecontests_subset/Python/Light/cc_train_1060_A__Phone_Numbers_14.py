n=int(input())
a=list(input())
k=a.count('8')
s=0
while k>0 and n>10:
    s+=1
    n-=11
    k-=1
print(s)

    