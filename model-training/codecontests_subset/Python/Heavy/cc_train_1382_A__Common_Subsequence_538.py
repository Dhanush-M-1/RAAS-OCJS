for _ in range(int(input())):
     n,m=map(int,input().split())
     liA=list(map(int,input().split()))
     liB=list(map(int,input().split()))
     liA.sort()
     liB.sort()
     f=0
     for i in range(n):
          for j in range(m):
               if liA[i]==liB[j]:
                    f=1
                    ans=liA[i]
               if f==1:
                    break
          if f==1:
               break
     if f==0:
          print("NO")
     else:
          print("YES")
          print(1,ans)
          