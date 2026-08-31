N=int(input())
abc="abcdefghijklmn"

def saiki(s,m):
  if len(s)==N:
    print(s)
  else:
    for i in range(m+2):
      if i<m+1:
        saiki(s+abc[i],m)
      else:
        saiki(s+abc[i],m+1)
    
saiki("a",0)