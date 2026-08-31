n=[int(x) for x in input().split()]

count=n[0]

while n[0]>=n[1]:
  count=count+int((n[0]/n[1]))
  n[0]=(n[0]%n[1])+int((n[0]/n[1]))
  
print(count)