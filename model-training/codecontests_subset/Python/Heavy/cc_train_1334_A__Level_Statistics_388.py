def check(arr1,arr2):
    for i in range(len(arr1)-1):
        if (arr2[i+1]-arr2[i])>(arr1[i+1]-arr1[i]):
            return True
    return False

for _ in range(int(input())):
    n=int(input())
    l=[]
    s=[]
    flag1=flag=False
    for i in range(n):
        a,b=map(int,input().split())
        l.append(a)
        s.append(b)
        if a<b:
            flag1=True
    flag=check(l,s) or l!=sorted(l) or s!=sorted(s)
    if flag or flag1:
        print("NO")
    else:
        print("YES")
