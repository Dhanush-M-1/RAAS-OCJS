
# coding: utf-8

# In[38]:


from sys import stdin
from io import StringIO


# In[39]:


# stdin = StringIO(
# '''3 6
# 2 3 5'''
# )


# In[40]:


n, k = map(int, stdin.readline().strip().split())
a = list(map(int, stdin.readline().strip().split()))


# In[42]:


ans = None
for i in a:
    if k % i == 0:
        if not ans or ans > k // i:
            ans = k // i


# In[44]:


print(ans)


# In[ ]:




