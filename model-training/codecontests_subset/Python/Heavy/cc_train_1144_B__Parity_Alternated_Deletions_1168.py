n = int(input())
In = input().split()
odd = []*0
even = []*0
answer = 0
for i in range (n):
   i = int(In[i])
   if (i%2 == 0):
      even.append(i)
   else:
      odd.append(i)
      
if (len(odd) != len (even) or 
    len(odd) != len (even)+1 or 
    len(odd) != len (even)-1):
   odd.sort()
   even.sort()
   lenDeffer=abs(len(odd)-len(even))
   if (len(odd) > len(even)):
      for i in range (lenDeffer-1):
         answer += odd[i]
   else:
      for i in range (lenDeffer-1):
         answer += even[i]
      
#print(even)
#print(odd)
print(answer)
        
