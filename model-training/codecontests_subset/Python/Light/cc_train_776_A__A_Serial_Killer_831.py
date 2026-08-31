f , k = map(str , input() .split())
n = int(input())
print(f,k)
t1 = f
t2 = k
for i in range (n):
  v1,v2 = map(str , input() .split())
  if v1 == t1:
    print(v2,t2)
    t1 = v2
    t2 = t2
  else:
    print(t1,v2)
    t1 = t1
    t2 = v2