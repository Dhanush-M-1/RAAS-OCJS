#!/usr/bin/env python
# coding: utf-8

# In[1]:


try:
    t = int(input())
    while(t!=0):
        n,m = map(int,input().split())
        a = list(map(int,input().split()))
        b = list(map(int,input().split()))
        result,vlaue = 0,0
        for i in range(n):
            if a[i] in b:
                result = 1
                vlaue = a[i]
                break
        if result == 0:
            print("NO")
        else:
            print("YES")
            print(1,vlaue,sep=" ")
        t = t-1
except EOFError:
    print(" ")


# In[ ]:




