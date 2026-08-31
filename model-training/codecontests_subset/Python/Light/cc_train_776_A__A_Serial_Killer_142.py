a,b=map(str,input().split())
n=int(input())
l=[]
l.append(a+" "+b)
for i in range(n):
    c,d=map(str,input().split())
    if c==a:
        l.append(d+" "+b)
        a=d
    if c==b:
        l.append(a+" "+d)
        b=d
for i in l:
    print(i)
