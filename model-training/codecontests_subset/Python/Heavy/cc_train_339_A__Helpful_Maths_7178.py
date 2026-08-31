w=input('')
w=w+'+'
a=len(w)
l=[]
m=[]
b=''
n=[]
for x in range(a):
      l.append(w[x])
for x in range(a):
      if l[x]!='+':
            b=b+l[x]
      else:
            m.append(b)
            b=''
for c in m:
      n.append(int(c))
d=len(n)
o=[]
for y in range(d):
      e=min(n)
      o.append(e)
      for x in range(len(n)):
            if n[x]==e:
                  n.pop(x)
                  break
            else:
                  pass
f=''
for z in range(d-1):
      f=f+str(o[z])+'+'
f=f+str(o[d-1])
print(f)
