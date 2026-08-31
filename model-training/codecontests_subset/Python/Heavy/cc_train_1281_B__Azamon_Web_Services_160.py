x="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
for _ in range(int(input())):
  s,t=input().split()
  d={}
  for i in x:d[i]=0
  for i in s:d[i]+=1
  j=0
  while d[x[j]]==0:j+=1
  ss=""
  f=False
  for i in range(len(s)):
    if f:ss+=s[i];continue
    if s[i]>x[j]:
      ss+=x[j]
      f=True
      dd=s[i]
    else:ss+=s[i]
    d[s[i]]-=1
    while d[x[j]]==0 and j!=25:j+=1
  if f:
    for i in range(len(s)-1,0,-1):
      if ss[i]==x[j]:
        if i!=len(s)-1:ss=ss[:i]+dd+ss[i+1:]
        else:ss=ss[:i]+dd
        break
  if ss<t:print(ss)
  else:print("---")