a,b=map(int,input().split())
res=a
while a>=b:
    a-=b-1
    res+=1
print(res)
