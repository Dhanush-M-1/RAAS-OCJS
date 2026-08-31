n=int(input())
a1=list(map(int,input().split()))
a2=list(map(int,input().split()))
a3=list(map(int,input().split()))
d1={}
d2={}
d3={}
a1.sort()
a2.sort()
a3.sort()
for i in a1:
      d1[i]=0
      d2[i]=0
      d3[i]=0
for i in range(len(a1)):
      d1[a1[i]]+=1
for i in range(len(a2)):
      d2[a2[i]]+=1
for i in range(len(a3)):
      d3[a3[i]]+=1
for i in d1:
      if d1[i]!=d2[i]:
            print(i)
for i in d1:
      if d2[i]!=d3[i]:
            print(i)