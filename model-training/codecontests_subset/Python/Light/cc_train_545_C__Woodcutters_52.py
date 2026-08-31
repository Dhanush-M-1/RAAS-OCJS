n=int(input())
tree=[]
for y in range(n):
    x,h=map(int,input().split())
    tree.append((x,h))
count=1
pre=tree[0][0]
if n==1:
    print(1)
else:
    for num in range(1,n-1):
      i=tree[num]
      j=tree[num+1]
      if i[0]>i[1]+pre:
        pre=i[0]
        count+=1
      elif i[0]+i[1]<j[0]:
        pre=i[0]+i[1]
        count+=1
      else:
        pre=i[0]
    print(count+1)

        
