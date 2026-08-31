n=int(input())
z=input()
sol=0
k=z.count('8')
while n>=11 and k>=1:
    if n>=11 and k>=1:
        sol+=1
        k-=1
        n-=11
    else:
        break
print(sol)
