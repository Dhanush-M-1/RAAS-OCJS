n =int(input(''))
ne = input('').split()
ne1 = input('').split()
ne2 = input('').split()
sum1=0
sum2=0
sum3=0
for i in ne :
     sum1+=int(i) 
for i in ne1 :
     sum2+=int(i)         
for i in ne2 :
     sum3+=int(i)
print(sum1-sum2) 
print(sum2-sum3)