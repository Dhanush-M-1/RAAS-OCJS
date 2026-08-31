'''

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

'''
#print ('Hello World')
n=int(input())
a=[]
b=[]
count=0
for i in range(n):
    (x,y)=map(int,input().split())
    a.append(x)
    b.append(y)
for each in a:
    for j in range(len(b)):
        if(each==b[j]):
            count+=1
print(count)