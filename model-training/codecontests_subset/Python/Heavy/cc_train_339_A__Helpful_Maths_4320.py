
y=input().split()

q=list(y[0])   ## list of digits and + signs...as strings
##print (q)


for i in range (1,len(q),2):
    q.remove('+')           ###list of only digits ..as strings


z=[int(x) for x in q]

z.sort()  ## list with digits in ascending order

z1=[str(x) for x in z]

for m in range (1,len(z1)*2-1,2):
    z1.insert(m,'+')                    ##inserting + signs , getting to the solution



string=z1[0]
for g in range (1,len(z1)):
    string=string+z1[g]      #almost done....got the original string...sorted with all + signs.
    

print (string)

