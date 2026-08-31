def DFS(word,n):
  if len(word)==N:
    return print(word)
  else:
    for i in range(n+1):
      if i==0 :
        DFS(word+chr(97+i),n+1)
      elif chr(97+i-1) in word:
        DFS(word+chr(97+i),n+1)

N=int(input())
DFS('',0)