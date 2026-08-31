n,m=map(int,input().split())
bulbs=[]
for i in range(n):
    s=list(map(int,input().split()))
    bulbs+=s[1:]
bulbs_set=set(bulbs)
print(['NO','YES'][len(bulbs_set)==m])