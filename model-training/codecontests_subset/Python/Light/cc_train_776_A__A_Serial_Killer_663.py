a=input().split()
ans=[a[0],a[1]]
for i in ans:
     print(i , end =" ")
print()
n= int(input())
for i in range(n):
     l = input().split()
     if l[0] in ans:
          ans.remove(l[0])
          ans.append(l[1])
     elif l[1] in ans:
          ans.remove(l[1])
          ans.append(l[0])
     for i in ans:
          print(i , end =" ")
     print()
