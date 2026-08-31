
def func(fr,to):
  global arr2
  if fr==to:
    return 0
  if fr<to:
    return -1
  temp=func(fr//2,to)
  if temp==-1:
    return temp
  return temp+1
n,k=map(int,input().split())
gans=-1
arr=sorted(list(map(int,input().split())))
ss=set()
ss.add(0)
for i in arr:
  temp=i
  while temp>0:
    ss.add(temp)
    temp=temp//2
for i in sorted(ss):
    cs=0
    tk=0
    for j in arr:
        if tk>=k:
            break
        temp=func(j,i)
        if temp<0:
            continue
        cs=cs+temp
        tk=tk+1
    if gans==-1:
        gans=cs
    else:
        if tk>=k:
            gans=min(gans,cs)
    #print(i,cs,tk,gans)
    #print(i,cs,tk)
print(gans)