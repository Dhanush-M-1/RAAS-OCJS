n, k = map(int,input().split())

ar11 = []
ar10 = []
ar01 = []

for i in range(n):
    t,a,b = map(int, input().split())
    if(a==1 and b==1):
        ar11.append(t)
    elif(a==1 and b==0):
        ar10.append(t)
    elif(a==0 and b==1):
        ar01.append(t)
# print(ar11, ar10, ar01)
if(len(ar11) + min(len(ar10), len(ar01)) >= k):
    ar10.sort()
    ar01.sort()
    
    for i in range(min(len(ar10), len(ar01))):
        ar11.append(ar10[i] + ar01[i])
    # print(ar11)
    ar11.sort()
    print(sum(ar11[:k]))
else:
    print("-1")
    
    