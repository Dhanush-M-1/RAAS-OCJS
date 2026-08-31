x = input()
p = x.split()
a = int(input())

array = []
for i in range(a):
  y = input()
  z = y.split()
  m = z[0]
  n = z[1]
  t = p.index(m)
  p[t] = n
  array.append(p[0])
  array.append(p[1])

print(x)
for i in range(0, (a*2), 2):
  print(array[i] + " " + array[i+1])



 	 	  	 		    			 	 				 			 		