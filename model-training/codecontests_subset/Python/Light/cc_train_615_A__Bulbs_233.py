n,m=map(int,input().split(" "))

bulbs_condition= [0]*m

for i in range(n):
    bulbes_which_will_be_on= list(map(int,input().split(" ")))
    del bulbes_which_will_be_on[0]
    for j in bulbes_which_will_be_on:
        bulbs_condition[j-1]=1
      
if 0 in bulbs_condition:
    print("NO")
else:
    print("YES")    