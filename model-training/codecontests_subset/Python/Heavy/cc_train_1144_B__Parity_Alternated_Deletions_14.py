from sys import stdin,stdout

def main():
    chet=0
    nechet=0

    C=[]
    N=[]
    
    n = int(stdin.readline())
    a=[int(x) for x in stdin.readline().replace('\n','').split()]
    for i in a:
        if i%2==0:
            chet+=1
            C.append(i)
        else:
            nechet+=1
            N.append(i)
    out=max(chet,nechet)-min(chet,nechet)-1

    if out==0:
        stdout.write('0\n')
    else:
        C.sort()
        N.sort()
        s=0
        if max(chet,nechet)==chet:
            for i in range(out):
                s+=C[i]
        else:
            for i in range(out):
                s+=N[i]
        stdout.write(str(s)+'\n')

main()