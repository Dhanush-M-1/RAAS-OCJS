def root(x,arr):
   # print(x)
   if x==arr[x]:
      return x
   return root(arr[x],arr)

if __name__=='__main__':
   n=int(input())
   roads=[]
   arr=[i for i in range(n+1)]
   dlt=[]
   for i in range(n-1):
      x,y=map(int,input().split(' '))
      roads.append([x,y])
      a=root(x,arr)
      b=root(y,arr)
      if a==b:
         dlt.append([x,y])
      else:
         arr[b]=a
   for i in range(1,n+1):
      arr[i]=root(i,arr)
   # print(arr)
   lst=list(set(arr))
   lst.remove(0)
   # print(lst)
   print(len(lst)-1)
   for i in range(len(lst)-1):
      print(f"{dlt[i][0]} {dlt[i][1]} {lst[i]} {lst[i+1]}")