n,k=[int(i) for i in input().split(" ")]
array=[int(i) for i in input().split()]
array.sort()
res=0
for i in array:
    if(k%i==0):
       res=k/i;
print(int(res))