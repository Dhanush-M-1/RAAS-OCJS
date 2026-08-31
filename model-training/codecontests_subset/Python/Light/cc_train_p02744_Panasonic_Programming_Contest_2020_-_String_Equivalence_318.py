N = int(input())
F="abcdefghijklmnopqrstuvwxyz"
def cy(ans,l):
  
  if len(ans)==N:
    print(ans)
  else:
    for i in range( min(l+2,27) ):
      k=ans+F[i]
      cy(k,max(l,i))

cy("a",0)