from sys import stdin,stdout
t = stdin.readline()
t = int(t)
while(t>0):
    n = stdin.readline() 
    n = int(n)
    a = [int(x) for x in stdin.readline().split()]
    flag = True
    pas = 0
    prev=  0
    for i in range(n):
        if flag ==  True and a[i]>=i:
            prev  =a[i]
            pass
        else:
            flag = False
            if pas== 0:
                pas = 1
                if (prev<=0 and i!=n-1) or (prev<=0 and i==n-1):
                    stdout.write('No'+'\n')
                    break
                elif a[i]==prev and prev!=0:
                    prev=  a[i]-1
                else:
                    prev= a[i]
            else:
                prev-=1
                if prev<0:
                    stdout.write('No'+'\n')
                    break
                elif prev<=0 and i!=n-1:
                    stdout.write('No'+'\n')
                    break
                elif a[i]<=prev:
                    prev = a[i]
    else:
        stdout.write('Yes'+'\n')    
    t-=1