
# coding: utf-8

# In[7]:


n = eval(input())
res = 0

for i in range(n):
    l, r, d = map(int, input().strip().split())
    if d < l:
        print(d)
    elif l <= d and d <= r:
        res = r // d * d + d
#        while(res <= r):
#            res += d
        print(res)
    else:
        print(d)

