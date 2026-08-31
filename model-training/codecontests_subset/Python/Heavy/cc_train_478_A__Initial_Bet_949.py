'''
def main():
    from sys import stdin,stdout
if __name__=='__main__':
    main()
'''
#158B
'''
TLE
def main():
    from sys import stdin,stdout
    from math import ceil
    n=int(stdin.readline())
    li=sorted(list(map(int,stdin.readline().split())),reverse=True)
    i=0
    while len(li):
        if li[0]==4:
            i+=1
            li=li[1:]
        elif li[0]==3:
            i+=1
            li=li[1:]
            if len(li):
                if li[-1]==1:
                    li=li[:-1]
        elif li[0]==2:
            i+=1
            li=li[1:]
            if len(li):
                if li[0]==2:
                    li=li[1:]
                elif li[0]==1:
                    li=li[1:]
                    if len(li):
                        li=li[2:]
        else:
            i+=ceil(len(li)/4)
            li=[]
    stdout.write(str(i))
if __name__=='__main__':
    main()
'''
#158B
'''
def main():
    from sys import stdin,stdout
    from math import ceil
    n=int(stdin.readline())
    li=tuple(map(int,stdin.readline().split()))
    i=li.count(4)
    count3=li.count(3)
    count2=li.count(2)
    count1=li.count(1)
    i+=count3
    if count1 >= count3:
        count1-=count3
    else:
        count1=0
    if count2 & 1:
        i+=(count2>>1)
        i+=1
        if count1:
            count1-=2
    else:
        if count2:
            i+=(count2>>1)
    if count1>0:
        i+=ceil(count1/4)
    stdout.write(str(i))
if __name__=='__main__':
    main()
'''
#460A
'''
def main():
    from sys import stdin,stdout
    n,m=map(int,stdin.readline().split())
    counter=n
    while n>=m:
        counter+=n//m
        n//=m
    if counter % m:
        stdout.write(str(counter))
    else:
        stdout.write(str(counter+1))
if __name__=='__main__':
    main()
'''
#520A
'''
def main():
    from sys import stdin,stdout
    stdin.readline()
    s=stdin.readline().strip().lower()
    flag=1
    for i in 'abcdefghijklmnopqrstuvwxyz':
        if i not in s:
            flag=0
            break
    if flag:
        stdout.write('YES')
    else:
        stdout.write('NO')
if __name__=='__main__':
    main()
'''
#25A
'''
def main():
    from sys import stdin,stdout
    n=int(stdin.readline())
    tup=tuple(map(int,stdin.readline().split()))
    etup=()
    otup=()
    for i in range(n):
        if tup[i] & 1:
            otup+=(i+1,)
        else:
            etup+=(i+1,)
    if len(otup)==1:
        stdout.write(str(otup[0]))
    else:
        stdout.write(str(etup[0]))
if __name__=='__main__':
    main()
'''
#478A
def main():
    from sys import stdin,stdout
    k=sum(map(int,stdin.readline().split()))
    if k%5:
        stdout.write('-1')
    else:
        if k//5:
            stdout.write(str(k//5))
        else:
            stdout.write('-1')
if __name__=='__main__':
    main()
