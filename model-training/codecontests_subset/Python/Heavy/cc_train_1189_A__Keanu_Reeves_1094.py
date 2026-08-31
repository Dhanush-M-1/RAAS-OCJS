n=input()

mat=input()

count1=0
count0=0

for i in range(len(mat)):
    if mat[i]=='1':
        count1=count1+1

    elif mat[i]=='0':
        count0=count0+1

if count1!=count0:
    print('1')
    print(mat)

else:
    print('2')
    if mat[len(mat)-1]=='0':
        
        new=mat[::-1].replace('0'[::-1],''[::-1],1)[::-1]
        
        #new=mat.replace('0','',1)
        print(new,'0')
        
        
    elif mat[len(mat)-1]=='1':
        
        new=mat[::-1].replace('1'[::-1],''[::-1],1)[::-1]
        
       # new=mat.replace('1','',1)
        print(new,'1')
        