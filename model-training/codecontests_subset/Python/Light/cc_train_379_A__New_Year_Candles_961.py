#!/usr/bin/env python
# coding: utf-8

# In[5]:


l=input()
a,b=l.split()
a,b=int(a),int(b)


# In[6]:


hours=a
while a>=b:
    c=a%b
    a=a//b
    hours+=a
    a+=c


# In[7]:


print(hours)


# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:




