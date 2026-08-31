for _ in range(int(input())):
     l,r,d=map(int,input().split())
     if l<=d:
          #print(d,r)
          if r%d==0:print(r+d)
          else:print(r+(d-r%d))
     else:
          print(d)
