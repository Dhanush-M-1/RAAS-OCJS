input()
q=0
q1=0
q2=0
for i in input().split(" "):
    q+=int(i)
for i in input().split(" "):
    q1+= int(i)
for i in input().split(" "):
    q2+= int(i)
print(q-q1)
print(q1-q2)