def solve():
   n=list(map(int,input().split()))
   v=[]
   n=int(n[0])
   for i in range(n):
       v.append(list(map(int,input().split())))
   c=0
   for i in range(n):
      # print(i)
       if (i!=0):
           if ((v[i][0]>=v[i-1][0]) and((v[i][0]-v[i-1][0])>=(v[i][1]-v[i-1][1])) and (v[i][1]>=v[i-1][1]) and (v[i][0]>=v[i][1])):
               c=0
           else:
               c=1
               break
       else:
           if(v[i][0]<v[i][1]):
               c=1
               break
   if (c==0):
       print("YES")
   else:
       print("NO")
    
        
      



t=input().split()
t=int(t[0])
for _ in range(t):
    solve()
