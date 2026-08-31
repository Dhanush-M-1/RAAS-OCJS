i= int(input())
j= str(input())
k= j.count('8')

ans=i
n=0
while ans>=11 and k>0:
    ans= ans-11
    k=k-1
    n=n+1
print(n)