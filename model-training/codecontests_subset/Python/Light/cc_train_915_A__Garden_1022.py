a,b = map(int, input().split())

c = input()
d = c.split(" ")
list = []
list2 = []

for i in range(0,len(d)):
  if b%int(d[i])==0:
    list.append(d[i])
    
for i in range(0,len(list)):
  list2.append(b/int(list[i]))
  
print(int(min(list2)))