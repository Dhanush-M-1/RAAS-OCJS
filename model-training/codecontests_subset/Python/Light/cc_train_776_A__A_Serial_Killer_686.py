#-------------Program--------------
#----Kuzlyaev-Nikita-Codeforces----
#-------------Training-------------
#----------------------------------

n1,n2=map(str,input().split())
n=int(input())
for i in range(n):
    v,f=map(str,input().split())
    print(n1,n2)
    if v==n1:
        n1=f
    else:
        n2=f
print(n1,n2)