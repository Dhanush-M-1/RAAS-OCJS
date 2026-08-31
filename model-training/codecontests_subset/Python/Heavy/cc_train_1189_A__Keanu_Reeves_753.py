#!/usr/bin/env python
# coding: utf-8

# In[1]:


n=int(input())
s=input()
tcount0=tcount1=0 
for i in range(n):
    if s[i]=='1':
        tcount1+=1 
        
    else:
        tcount0+=1 
    
if tcount0!=tcount1:
    print(1)
    print(s)
    
else:
    count0=count1=0 
    for i in range(n):
        if s[i]=='1':
            count1+=1 
            
        else:
            count0+=1 
            
        if count1!=count0:
            if (tcount1-count1)!=(tcount0-count0):
                print(2)
                print(s[:i+1]+' '+s[i+1:])
                break
    


# In[ ]:




