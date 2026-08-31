def find(l,r,d):
    if d<l:
        return d
    elif d>r:
        return d
    else:
        return ((r//d)+1)*d

t=int(input())
lst=[]
for i in range(0,t):
    l,r,d=input().split()
    ele=find(int(l),int(r),int(d))
    lst.append(ele)

for i in range(0,t):
    print(lst[i])