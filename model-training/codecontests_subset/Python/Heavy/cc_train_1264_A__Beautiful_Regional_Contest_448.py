T=int(input())
for _ in range(T):
 n=int(input())
 a=list(map(int,input().split()))
 #
 d={}
 for i in a:d[i]=d.get(i,0)+1
 arr=[]
 for i in d:arr.append([i,d[i]])
 #
 #print(d)
 cnt=0;move=[];i=0;total=0;n=len(arr)
 while i<n:
  if len(move)==0:cnt=arr[i][1];total=cnt;move.append(cnt);i+=1
  elif  len(move)==3:break
  elif len(move)==2:
      while total<=len(a)//2 and i<n:
        total+=arr[i][1]
        #print(total,arr[i][0],arr[i][1])
        i+=1
      if total>n//2:total-=arr[i-1][1]
      summ=sum(move)
      if total-summ>move[0]:move.append(total-summ)
      break
  elif len(move)==1:
     cnt1=0;
     while cnt1<=cnt and i<n:
      cnt1+=arr[i][1]
      i+=1
     move.append(cnt1)
     total+=cnt1
     
# print(move)
 if len(move)==3:print(*move)
 else:print(0,0,0)
   
    
