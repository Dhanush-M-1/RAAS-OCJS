n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

a.sort()
b.sort()
c.sort()

""" print(a)
print(b)
print(c) """

i = 0
while i < len(b):
    if a[i] != b[i]:
        print(a[i])
        break
    i += 1
if i == len(b):
    print(a[i])
i = 0
while i < len(c):
    if b[i] != c[i]:
        print(b[i])
        break
    i += 1
if i == len(c):
    print(b[i])

	  	  		 	   		 				 		 	  	 	