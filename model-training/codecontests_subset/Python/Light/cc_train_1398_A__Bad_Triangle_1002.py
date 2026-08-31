#!/usr/bin/env python
# coding: utf-8

# In[15]:


t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int , input().split()))
    if sum(a[:2]) > a[-1]:
        print(-1)
    else:
        print(1 , 2 , len(a))


# In[ ]:




