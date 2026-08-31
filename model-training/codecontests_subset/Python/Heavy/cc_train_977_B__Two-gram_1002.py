#!/usr/bin/env python
# coding: utf-8

# In[4]:


# import math
# for i in range(int(input())):
#     a,b=map(int,input().split())
#     if a%b==0 or a%b<=1.5:
#         print(a)
#     else:
#         no=int(a/b)
#         no+=.5
#         print(math.floor(b*no))


# In[10]:


# import math
# for i in range(int(input())):
#     a,b=map(int,input().split())
#     frac,asd=math.modf(a/b)
#     if a%b==0 or frac<=.5:
#         print(a)
#     else:
#         no=int(a/b)
#         no+=.5
#         print(int(b*no))


# In[4]:


n=int(input())
s=input()
d={}
a=0
for i in range(n-1):
    a=s[i]+s[i+1]
    if d.get(a):
        d[a]+=1
    else:
        d[a]=1
max_key = max(d, key=d.get)
print(max_key)
    
    


# In[ ]:




