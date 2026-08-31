import heapq
for _ in range(int(input())):
  N=int(input())
  ls=[[int(s) for s in input().split()] for _ in range(N)]
  #Li>=RiのラクダとLi<Riのラクダにわける
  lsL=[]
  lsR=[]
  constL=0
  constR=0
  for i in range(N):
    if ls[i][1]>=ls[i][2]:
      lsL.append((ls[i][0],ls[i][1]-ls[i][2]))
      constL+=ls[i][2]
    else:
      lsR.append((N-ls[i][0],ls[i][2]-ls[i][1]))
      constR+=ls[i][1]
  lsL=sorted(lsL, key=lambda x:-x[0])
  lsR=sorted(lsR, key=lambda x:-x[0])
  
  trainL=[]
  trainR=[]
  heapq.heapify(trainL)
  heapq.heapify(trainR)
  len_trainL=0
  len_trainR=0
  
  for j in range(1,N+1):
    #trainLにKi=jであるものを追加
    while lsL!=[] and lsL[-1][0]==j:
      len_trainL+=1
      heapq.heappush(trainL,lsL[-1][1])
      del lsL[-1]
    #trainLの長さがjを超えた場合、取り除いていく
    while len_trainL>j:
      a=heapq.heappop(trainL)
      len_trainL-=1
      
  for j in range(N+1):
    #trainRにKi=jであるものを追加
    while lsR!=[] and lsR[-1][0]==j:
      len_trainR+=1
      heapq.heappush(trainR,lsR[-1][1])
      del lsR[-1]
    #trainRの長さがjを超えた場合、取り除いていく
    while len_trainR>j:
      a=heapq.heappop(trainR)
      len_trainR-=1
      
  print(constL+constR+sum(trainL)+sum(trainR))

    
    