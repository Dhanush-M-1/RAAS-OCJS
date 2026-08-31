#!/usr/bin/env python
# coding: utf-8

# In[204]:


# # n = int(input())
# # line = list(map(int, input().split()))


# In[462]:


str_list = list(str(input()))


# In[464]:


num_list = []
ans = ''

for c in str_list:
    if c != '+':
        num_list.append(int(c))
    
if len(num_list) < 2:  
    ans += str(num_list[0])
else:
    num_list = sorted(num_list)
    ans += str(num_list[0]) + '+'

    for i in range(1, len(num_list) -1 ):
        ans += str(num_list[i]) + '+'

    ans += str(num_list[-1])

print(ans)


# In[ ]:





# In[ ]:




