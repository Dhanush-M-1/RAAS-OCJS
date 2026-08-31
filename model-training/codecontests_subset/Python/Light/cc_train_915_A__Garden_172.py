#-------------Program--------------
#----Kuzlyaev-Nikita-Codeforces----
#-------------Training-------------
#----------------------------------

n,k=map(int,input().split())
a=list(map(int,input().split()))
m=0
for i in range(n):
   if k%a[i]==0 and a[i]>m:
      m=a[i]
print(k//m)