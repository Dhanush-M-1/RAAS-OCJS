#-------------Program--------------
#----Kuzlyaev-Nikita-Codeforces----
#-------------Training-------------
#----------------------------------

n=int(input())
a=list(str(input()))
v=a.count("8");r=n-v
answer=0
for i in range(n):
    if v==0:
        break
    if r>=10:
        v-=1;r-=10;answer+=1
    else:
        if v>=(10-r)+1:
            v-=11-r
            r=0
            answer+=1
        else:
            break
print(answer)