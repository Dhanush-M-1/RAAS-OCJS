def gcd(x, y):
	while y:
		x, y = y, x % y
	return x

t = int(input())
a = []
d = 0
for i in range(t):
  a.append(list(map(int,input().split())))
for j in a:
  if j[0] < j[1] or j[1] > j[3]:
    print("No")
  else:
    b = j[0] % j[1]
    k = gcd(j[1],j[3])
    c = j[0] % k
    d = j[2] % k
    if c > d:
      e = j[2] + c - d
    else:
      e = j[2] + k + c - d

    if j[1] > e:
      print("No")
    else:
      print("Yes")
    
    
    