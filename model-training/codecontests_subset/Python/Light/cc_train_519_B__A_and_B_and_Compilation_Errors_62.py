n=int(input())
s1=0
s2=0
s3=0
a1=[int(n) for n in input().split(" ")]
a2=[int(n) for n in input().split(" ")]
a3=[int(n) for n in input().split(" ")]
for i in range(len(a1)):
    s1=s1+a1[i]
for i in range(len(a2)):
    s2=s2+a2[i]
for i in range(len(a3)):
    s3=s3+a3[i]
print(s1-s2)
print(s2-s3)
