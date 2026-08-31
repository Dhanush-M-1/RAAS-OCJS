n,m=map(int,input().split())
s=[]
num=0
for i in range(n):
    new=list(str(input()).split())
    new=[int(i) for i in new]
    num+=int(new[0])
    newtoadd=new[1:]
    s+=newtoadd
result="NO"
for i in range(m):
    if i+1 not in s:
        result="NO"
        break
    else:
        result="YES"
print(result)