a=lambda:map(int,input().split());b,c=a()
for i in sorted(list(a()),reverse=True):
    if c%i==0:print(c//i);exit()