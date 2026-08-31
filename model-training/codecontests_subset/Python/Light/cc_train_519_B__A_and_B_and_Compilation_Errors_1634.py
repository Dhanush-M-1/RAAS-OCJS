n=int(input())
arr1=[int(x) for x in input().split()]
arr2=[int(x) for x in input().split()]
arr3=[int(x) for x in input().split()]

arr1.sort()
arr2.sort()
arr3.sort()

flag=0
for i in range(0,len(arr2)):
  if arr1[i]!=arr2[i]:
    print(arr1[i])
    flag=1
    break
if flag==0:
  print(arr1[-1]) 

flag=0
for i in range(0,len(arr3)):
  if arr2[i]!=arr3[i]:
    print(arr2[i])
    flag=1
    break
if flag==0:
  print(arr2[-1]) 

  