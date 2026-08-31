n,m = input().split()
n = int(n)
m = int(m)
anse = n;
while(True):
   if((n-(n%m))%m == 0  and n>1):
      anse = anse + n/m
      n = n/m
      
      
   else:
      break
print(int(anse))
