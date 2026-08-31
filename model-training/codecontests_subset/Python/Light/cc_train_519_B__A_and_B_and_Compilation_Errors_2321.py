n=int(input())
a=map(int,input().split())
b=map(int,input().split())
c=map(int,input().split())
def sum1(x):
    s=0
    for i in x:
        s+=i
    return s
sa=sum1(a)
sb=sum1(b)
sc=sum1(c)
print(sa-sb)
print(sb-sc)
