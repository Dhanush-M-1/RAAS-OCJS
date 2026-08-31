import sys
input=sys.stdin.readline
s=input().rstrip()
l=list(s.split(" "))
p=1
m=0
for ss in l:
    if ss=="+":
        p+=1
    if ss=="-":
        m+=1
n=int(l[-1])
if n*p-m<n or p-m*n>n:
    print("Impossible")
    exit()
arr_p=[1]*p
arr_m=[1]*m
r=p-m
for i in range(p):
    xx=min(n-1,max(n-r,0))
    arr_p[i]+=xx
    r+=xx
for i in range(m):
    xx=min(n-1,max(r-n,0))
    arr_m[i]+=xx
    r-=xx
ans=[]
pre=1
for i in range(len(l)):
    if l[i]=="?":
        if pre:
            ans.append(str(arr_p.pop()))
        else:
            ans.append(str(arr_m.pop()))
    else:
        if l[i]=="+":
            pre=1
            ans.append(l[i])
        elif l[i]=="-":
            pre=0
            ans.append(l[i])
        else:
            ans.append(str(l[i]))
print("Possible")
print(" ".join(ans))