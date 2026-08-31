n=int(input())
m=input()
res=0
eig=m.count("8")
while n>=11 and eig>0:
    if n>=11 and eig>0:
        res+=1
        eig-=1
        n-=11
    else:
        break
print(res)
