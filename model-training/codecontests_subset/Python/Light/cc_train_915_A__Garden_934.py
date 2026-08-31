a,b=map(int,input().split())
l=list(filter(lambda x:b%int(x)==0,input().split()))
m=[b//int(l[x]) for x in range(len(l))]
print(min(m))