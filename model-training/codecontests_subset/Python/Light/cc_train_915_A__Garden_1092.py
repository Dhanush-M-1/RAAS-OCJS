n,k =[int (x) for x in input().split()]
y= list( int(i) for i in input().split() )
m=0;
for i in y:
    if(k%i == 0):
        if(i > m):
            m=i
print(int(k/m))