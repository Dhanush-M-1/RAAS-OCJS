import math     
def process(A, n, e):
  B=[]
  D={}
  for i in A:
    k=i
    C=[]
    while k >= 1:
      C.append(k)
      D[k]=D.get(k,0)+1
      k=k//2
    
    B.append(C)
    E=[]
  for i in D.keys():
    if D[i] >= e:
      E.append(i)
 
  # for i in range(len(B)):
  #   print(B[i])

  # print(E)
  res=1e30
  for i in E:   
    F=[]
    for q in range(len(B)):   
      for t in range(len(B[q])):
        if B[q][t]==i:
          F.append(t)
          break
    F.sort()

    
    res=min(res, sum(F[0: e]))
  
    
  return res 
 
n, k=[int(x) for x in input().split()]
A=[int(x) for x in input().split()]
print(process(A, n , k))