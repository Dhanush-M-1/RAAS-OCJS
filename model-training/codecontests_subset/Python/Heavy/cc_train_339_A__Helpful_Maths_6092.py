s = str(input())
l = list(s)


lengthofstring = len(s)
numberofnumbers = (lengthofstring/2) + 0.5

numbers = []


i = 0
c = 0
for i in range(0, lengthofstring):

       if (i%2 == 0):
              numbers.insert(c, l[i])
              c = c + 1  
       i = i + 1


numbers = list(map(int,numbers))
numbers.sort()
numbers = list(map(str,numbers))


i = 0
c = 0
out = list()
for i in range(0, lengthofstring):
       if (i%2 == 0):
              out.insert(i, numbers[c])
              c = c + 1
       if (i%2 != 0):
              out.insert(i, '+')
       i = i + 1

out2 =''. join(map(str, out))
print(out2)
              
