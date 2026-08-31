#!/usr/bin/env python
# coding: utf-8

# In[37]:


string = input()
if len(string)==1:
    print(string)
else:
    numbers = string.split("+")
    removal = []
    for i in range(len(numbers)):
        if numbers[i]=="":
            removal.append(i)
        removal.sort(reverse=True)
    for x in removal:
        numbers.pop(x)
    for i in range(len(numbers)):
        numbers[i] = int(numbers[i])
    numbers.sort()
    for i in range(len(numbers)):
        numbers[i] = str(numbers[i])
    print("+".join(numbers))
    


# In[ ]:





# In[ ]:




