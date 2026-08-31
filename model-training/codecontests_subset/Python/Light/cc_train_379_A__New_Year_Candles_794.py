q,w=map(int,input().split())
s=q
e=0
while (q)//w>0:
    
    s+=q//w
    q=q//w+q%w
print(s)
