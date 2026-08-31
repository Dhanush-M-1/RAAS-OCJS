def func():
   temp=list(map(int,input().split()))
   l,r,d=temp[0],temp[1],temp[2]
   temp=d
   if d<l or d>r:
       print(d)
       return
   else:
    print((r//d+1)*d)
q=int(input())
for i in range(q):
    func()
