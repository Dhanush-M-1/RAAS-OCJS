def spdvd(a,b):
    if a%b==0:
        return a/b-1
    return a/b


q= int(input())
for i in range(q):
    l,r,x= list(map(int,(input().split())))
    a= x* int(spdvd(l,x)); b= x* (int(r/x)+1)
    if a>x:
        print(x)
    elif min(a,b)>0:
        print(min(a,b))
    else: print(max(a,b))
