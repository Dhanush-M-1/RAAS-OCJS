n=int(input())
a=list(map(int,input().split()))
sa=0
for x in a:
    sa+=x
b=list(map(int,input().split()))
sb=0
for x in b:
    sb+=x
    
c=list(map(int,input().split()))
sc=0
for x in c:
    sc+=x
print(str(sa-sb)+' '+str(sb-sc))
