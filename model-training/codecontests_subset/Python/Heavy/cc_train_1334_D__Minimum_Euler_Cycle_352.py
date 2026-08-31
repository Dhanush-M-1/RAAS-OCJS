#!/usr/bin/env python
# coding: utf-8

# In[48]:


#from __future__ import print_function
#from sys import stdin


# In[52]:


cases = int( input() )


# In[53]:


def ecycle(n,l,r):
    l-=1
    cnt = r - l 
    
    p = n-1
    start = 1
    while(l >= 2*p and p>0):
        l -= 2*p
        p -= 1
        start += 1
        
    if(start==n):
        start = 1
    
    
    flag = (l+1)%2
    nextn = start + 1 + l//2
    
    
    while(cnt>0):
        cnt-=1
        if(flag==1):
            print(start,end=" ")
        if(flag==0):
            print(nextn, end=" ")
            nextn += 1
        if(nextn>n):
            start += 1
            nextn = start + 1
            flag = 0
            
            if(start==n):
                start = 1
        
        flag = 1-flag
        
        
    
    


# In[54]:



while(cases>0):
    n,l,r = map( int, input().split() )
    ecycle(n,l,r)
    cases -= 1


# In[ ]:




