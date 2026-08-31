def swapPositions(S, pos1, pos2): 
    S[pos1], S[pos2] = S[pos2], S[pos1] 
    return S
t=int(input())
for _ in range(t):
  s,c=input().split()
  if s<c:
    print(s)
  else:
    S=list(s)
    P=S[::]
    S.sort()
#     print(S)
    i=0
    while i<len(s) and s[i]==S[i]:
      i+=1
#     print(i)
    loc=-1
    for j in range(i+1,len(s)):
      if s[j]==S[i]:
        loc=j
#     print(i,loc)
    if loc!=-1:
      P=swapPositions(P,i,loc)
#       print("worked")
#     print(P)
    s="".join(P)
    if s<c:
      print(s)
    else:
      print("---")