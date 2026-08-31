# ----rgkbitw----
# 4.10.2017
n,m=map(int,input().split())
want=set(range(1,m+1))
s=[]
for i in range(n):
    s+=list(map(int,input().split()))[1:]
if set(s)==want:
    print("YES")
else:
    print("NO")
    
