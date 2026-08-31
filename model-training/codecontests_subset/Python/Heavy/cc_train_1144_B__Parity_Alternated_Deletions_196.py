t = int(input())
cnt = 0
su =0
def init(a):
    for p in range(len(a)):
        a[p] = int(a[p])
    return(a)
'''def swap(a):
    for i in range(len(a)-1):
        temp = a[i] 
        a[i] = a[i+1]
        a[i+1] = temp
    return(a)'''
d = input().split()
d =  init(d)
e =[]
o = []
for i in range(len(d)):
    if d[i]%2 == 0:
        e.append(d[i])
    else:
        o.append(d[i])
e = sorted(e)
o = sorted(o)
h = len(e)-len(o)
if abs(h) < 2:
    su = 0
elif h > 0:
    su =  sum(e[:abs(h)-1])
elif h < 0:
    su = sum(o[:abs(h)-1])
print(su)



    

