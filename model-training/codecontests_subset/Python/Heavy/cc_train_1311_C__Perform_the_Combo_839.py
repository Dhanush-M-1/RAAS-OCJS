t=int(input())
import string

while(t!=0):
    d = {"a":0,"b":0,"c":0,"d":0,"e":0,"f":0,"g":0,"h":0,"i":0,"j":0,"k":0,"l":0,"m":0,"n":0,"o":0,"p":0,"q":0,"r":0,"s":0,"t":0,"u":0,"v":0,"w":0,"x":0,"y":0,"z":0}
    n, m = map(int, input().split())
    s = list(input())
    p = list(map(int, input().split()))
    a=[0]*n
    b=[0]*n
    #print(s)
    
    for el in p:
        a[el-1] = a[el-1] + 1
    temp = sum(a)
    for i in range(n):
        if(i!=0):
            b[i] = temp-a[i-1] 
            temp = b[i]
        else:
            b[i] = temp 
    #print(b)
    k=0
    for ch in s:
        d[ch] = d[ch] + b[k] + 1
        k = k + 1

    print(*list(d.values()))
    t=t-1
