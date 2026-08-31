for _ in range(int(input())):
      n=int(input())
      a=list(map(int,input().split()))
      x=a[0]
      y=a[1]
      c=0
      k=0
      for i in range(2,n):
            if x+y<=a[i]:
                  c=0
                  k=i
                  break
            else:
                  c=c+1
      if c==0:
            print(1,2,k+1)
      else:
            print(-1)