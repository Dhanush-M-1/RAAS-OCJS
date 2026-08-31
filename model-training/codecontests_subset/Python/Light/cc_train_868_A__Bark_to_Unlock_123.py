def cal(s,a):
    if a in s:
        return "YES"
    else:
        l=0
        f=0
        for p in s:
            if a[0]==p[1]:
                l=1
            if a[1]==p[0]:
                f=1
        if f==1 and l==1:
            return "YES"
        else:
            return "NO"


a=input()
n=int(input())
s=[]
for i in range(0,n):
    s.append(input())
print(cal(s,a))