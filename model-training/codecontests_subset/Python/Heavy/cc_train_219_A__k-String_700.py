#!/usr/bin/env python
# coding: utf-8

# In[204]:


# # n = int(input())
# # line = list(map(int, input().split()))
# # line = list(str(input()))


# In[1]:


from collections import Counter


# In[2]:


n = int(input())
line = str(input())


# In[5]:


c_dict = Counter(line)
seg_dict = {}

for k, v in c_dict.items():
    seg_dict[k] = v//n 
    


# In[7]:


sync = all([i%n != 1 for i in c_dict.values()])

res = ''

if min(c_dict.values()) < n or sync == False:
    print(-1)
else:
    while max(c_dict.values()) != 0:
        for k in c_dict.keys():
            for _ in range(seg_dict[k]):
                res += k
                c_dict[k] -= 1
print(res)


# In[ ]:





# In[ ]:





# In[23]:





# In[ ]:


# https://codeforces.com/problemset/problem/124/A

