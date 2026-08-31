n = int(input())
uniform = {}
home_uniform = []

ts = 0
while n>0:
        n -= 1
        h,a= [int(j) for j in input().split()]

        while (h,ts) in uniform:
                ts += 1
        uniform[(h,ts)] = a
        home_uniform.append( (h,ts) )

cnt = 0
guest_uniform = []
for hu in home_uniform:
        for k,v in uniform.items():
                if k==hu: continue
                
                guest_uniform.append(v)

        for gu in guest_uniform:
                if hu[0]==gu:
                        cnt += 1

        guest_uniform.clear()
       
print(cnt)
