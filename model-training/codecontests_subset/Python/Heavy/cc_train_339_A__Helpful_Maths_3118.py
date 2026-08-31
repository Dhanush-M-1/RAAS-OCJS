from sys import stdin, stdout
def get_ints(): return map(int,stdin.readline().strip().split()) 
def get_array(): return list(map(int,stdin.readline().strip().split()))
def get_string(): return stdin.readline().strip()
def op(c): return stdout.write(str(c))
#for _ in range(int(stdin.readline())):
s=get_string()
a=[]
for i in s:
    if i!="+":
        a.append(int(i))
a.sort()
for i in range(len(a)):
    if i==len(a)-1:
        print(a[i],end="")
    else:
        print(a[i],"+",end="",sep="")

    