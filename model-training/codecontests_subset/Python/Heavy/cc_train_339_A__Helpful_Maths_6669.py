s = str(input())
l = list(s)
#print(l)

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

#print(numbers)
numbers = list(map(int,numbers))
numbers.sort()
numbers = list(map(str,numbers))
#print(numbers)

j = 0
v = 0
out = list()
for j in range(0, lengthofstring):
       if (j%2 == 0):
              out.insert(j, numbers[v])
              v = v + 1
       if (j%2 != 0):
              out.insert(j, '+')
       j = j + 1

out2 =''. join(map(str, out))
print(out2)
              


#zoby = numbers[0] + numbers[1]
#print(zoby)
       
#print(numbers)
       
              
              


#(lengthofstring-1)numbers[c] = l[i]
