n = int(input())

a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

a = sorted(a)
b = sorted(b)
c = sorted(c)

found = False
for i in range(n - 1):
  if a[i] != b[i]:
    print(a[i])
    found = True
    break

if not found:
  print(a[-1])

found = False
for i in range(n - 2):
  if b[i] != c[i]:
    print(b[i])
    found = True
    break

if not found:
  print(b[-1])

			 		  	 	 							  		 					