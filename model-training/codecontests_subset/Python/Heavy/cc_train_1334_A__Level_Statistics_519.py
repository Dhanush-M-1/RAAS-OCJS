if __name__ == "__main__":  
  T = int(input())
  results = []
  for i in range(T):
    N = int(input())
    stats =[]
    for j in range(N):
      p,c = map(int, input().split(' '))
      stats.append([p,c])
    lastP = stats[0][0]
    lastC = stats[0][1]
    quit=False
    if lastP>=lastC:
      for stat in range(1,N):        
        P = stats[stat][0]
        C = stats[stat][1]        
        if P<lastP or C<lastC:
          print("NO")
          quit=True
          break
        elif C>P:
          print("NO")
          quit=True
          break
        elif C-lastC > P-lastP:
          print("NO")
          quit=True
          break
        lastP=P
        lastC=C
      if not quit:
        print("YES")
    else:
      print("NO")