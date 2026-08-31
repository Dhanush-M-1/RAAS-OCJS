#!/usr/bin/env python
# coding: utf-8

# In[5]:


b=int(input())
for i in range(b):
    c=[]
    m=input().split()
    user_input = input().split()
    user_input2 = input().split()
    #strip is used to remove the white space. Not mandatory
    a = [int(x.strip()) for x in user_input]
    b=[int(x.strip()) for x in user_input2]
    for i in range(len(a)):
        if a[i] in b:
            c.append(a[i])
            print('YES')
            print(len(c),c[0])
            break
    if c==[]:
        print('NO')


# In[ ]:




