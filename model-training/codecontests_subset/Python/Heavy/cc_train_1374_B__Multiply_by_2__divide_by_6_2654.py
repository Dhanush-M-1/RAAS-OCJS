#!/usr/bin/env python
# coding: utf-8

# In[ ]:


n=int(input())
for i in range(n):
    x=int(input())
    if x==1:
        print(0)
    else:
        c=0
        if x<6:
            x=x*2
            c+=1
        flag=True
        i=x
        while i>1:
            if x%6==0:
                x=x//6
                c+=1
            elif (x*2)%6!=0:
                flag=False
                print(-1)
                break
            else:
                x=x*2
                c+=1
            if x==1:
                flag=False
                print(c)
            i=x
        if flag:
            print(-1)
            
            


# In[ ]:




