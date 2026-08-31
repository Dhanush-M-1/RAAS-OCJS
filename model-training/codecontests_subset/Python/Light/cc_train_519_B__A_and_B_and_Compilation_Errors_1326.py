t=int(input())
l=[]
for i in range(3):
    s=input().split()
    s=list(map(int,s))
    l.append(s)
s1,s2,s3=0,0,0
for i in l[0]:
    s1+=i
for j in l[1]:
    s2+=j
for k in l[2]:
    s3+=k
print(s1-s2)
print(s2-s3)