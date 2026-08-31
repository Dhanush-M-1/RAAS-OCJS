#!/usr/bin/env python
# coding: utf-8

# In[1]:


try:
    t = int(input())
    while(t!=0):
        n = int(input())
        arr = list(map(int,input().split()))
        if(arr[0] + arr[1] <= arr[n-1]):
            print(1,2,n)
        else:
            print(-1)
        t = t-1
except EOFError:
    print(" ")


# In[ ]:




