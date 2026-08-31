#!/usr/bin/env python
# coding: utf-8

# In[7]:


a,b=map(int,input().split())
count=0
x=1
while a>=0:
    if count==x*b:
        x+=1
        a+=1
    a-=1
    count+=1
print(count-1)


# In[ ]:




