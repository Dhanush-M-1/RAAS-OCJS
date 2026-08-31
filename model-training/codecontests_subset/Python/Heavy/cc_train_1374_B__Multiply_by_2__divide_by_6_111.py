from sys import stdin,stdout
t=int(stdin.readline().strip())
for _ in range(t):
    n=int(stdin.readline().strip())
    if n==1:
        stdout.write("0"+"\n")
        continue
    elif n==3:
        stdout.write("2"+"\n")
        continue
    elif n<6 :
        stdout.write("-1"+"\n")
        continue
    c=0
    f=0
    while n>=6 or n==3:
        if n%6==0:
            n=int(n/6)
            c+=1
        elif n%3==0:
            n=int((n*2)/6)
            c+=2
        else:
            f=1
            break

    if f==1:
        stdout.write("-1"+"\n")
    elif n==1:
        stdout.write(str(c)+"\n")
    else:
        stdout.write("-1"+"\n")
