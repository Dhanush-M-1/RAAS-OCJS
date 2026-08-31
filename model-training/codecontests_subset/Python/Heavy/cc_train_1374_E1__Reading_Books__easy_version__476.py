n,k = map(int,input().split())
U = [];A = [];B = []
for i in range(n):
    a,b,c = map(int,input().split())
    if(b==1 and c==1):
        U.append(a)
    elif(b==1 and c==0):
        A.append(a)
    elif(b==0 and c==1):
        B.append(a)
A.sort();B.sort();U.sort()
for i in range(1,len(U)):
    U[i]+=U[i-1]
for i in range(1,len(A)):
    A[i]+=A[i-1]
for i in range(1,len(B)):
    B[i]+=B[i-1]
f_ans = 1e10
cnt = 0;ans =0 
for i in range(-1,len(U)):
    cnt = i+1;ans = 0
    if(i>=0):
        ans = U[i]
    if(k-cnt==0):
        f_ans = min(ans,f_ans)
        break
    if(k-cnt>len(A) or k-cnt >len(B)):
        continue
    ans += A[k-cnt-1] + B[k-cnt-1]
    cnt = k
    f_ans = min(f_ans,ans)
f_ans = min(ans,f_ans)
if(k-cnt>0):
    print("-1")
else:
    print(f_ans)