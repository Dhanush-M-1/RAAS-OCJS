'''
def main():
    from sys import stdin,stdout
if __name__=='__main__':
    main()
'''
#1A
'''
def main():
    from sys import stdin,stdout
    from math import ceil
    n,m,a=map(int,stdin.readline().split())
    stdout.write(str(ceil(n/a)*ceil(m/a)))
if __name__=='__main__':
    main()
'''
#4A
'''
def main():
    from sys import stdin,stdout
    i=int(stdin.readline())
    if i&1:
        stdout.write('NO\n')
    else:
        if i//2 >1:
            stdout.write('YES\n')
        else:
            stdout.write('NO\n')
if __name__=='__main__':
    main()
'''
#71A
'''
def main():
    from sys import stdin,stdout
    for _ in range(int(stdin.readline())):
        s=stdin.readline().strip()
        if len(s) <=10:
            stdout.write(s+'\n')
        else:
            stdout.write(s[0]+str(len(s[1:-1]))+s[-1]+'\n')
if __name__=='__main__':
    main()
'''
#158A
'''
def main():
    from sys import stdin,stdout
    n,k=map(int,stdin.readline().split())
    a=list(map(int,stdin.readline().split()))
    count=0
    for i in range(n):
        if a[i] and a[i]>=a[k-1]:
            count+=1
    stdout.write(str(count))
if __name__=='__main__':
    main()
'''
#188A
'''
def main():
    from sys import stdin,stdout
    s=stdin.readline().strip()
    t=''
    s=s.lower()
    for i in s:
        if i not in 'aeiouy':
            t+='.'+i
    stdout.write(t)
if __name__=='__main__':
    main()
'''
#50A
'''
def main():
    from sys import stdin,stdout
    n,m=map(int,stdin.readline().split())
    stdout.write(str((n*m)//2))
if __name__=='__main__':
    main()
'''
#231A
'''
def main():
    from sys import stdin,stdout
    count=0
    for _ in range(int(stdin.readline())):
        if sum(list(map(int,stdin.readline().split())))>=2:
            count+=1
    stdout.write(str(count))
if __name__=='__main__':
    main()
'''
#282A
'''
def main():
    from sys import stdin,stdout
    x=0
    for _ in range(int(stdin.readline())):
        s=stdin.readline().strip()
        if '++' in s:
            x+=1
        elif '--' in s:
            x-=1
    stdout.write(str(x))
if __name__=='__main__':
    main()
'''
#158B
#WA
'''
def main():
    from sys import stdin,stdout
    from math import ceil
    stdin.readline()
    stdout.write(str(ceil(sum(list(map(int,stdin.readline().split())))/4)))
if __name__=='__main__':
    main()
'''
#96A
'''
def main():
    from sys import stdin,stdout
    s=stdin.readline().strip()
    count=1
    flag=0
    for i in range(1,len(s)):
        if s[i]==s[i-1]:
            count+=1
            if count >=7:
                flag=1
                break
        else:
            count=1
    if flag:
        stdout.write('YES')
    else:
        stdout.write('NO')
if __name__=='__main__':
    main()
'''
#116A
'''
def main():
    from sys import stdin,stdout
    maxim=0
    total=0
    for _ in range(int(stdin.readline())):
        a,b=map(int,stdin.readline().split())
        total+=(b-a)
        if total >maxim:
            maxim=total
    stdout.write(str(maxim))
if __name__=='__main__':
    main()
'''
#112A
'''
def main():
    from sys import stdin,stdout
    s=stdin.readline().strip().lower()
    t=stdin.readline().strip().lower()
    if s==t:
        stdout.write('0')
    elif s < t:
        stdout.write('-1')
    else:
        stdout.write('1')
if __name__=='__main__':
    main()
'''
#339A
def main():
    from sys import stdin,stdout
    l=list(map(str,stdin.readline().strip().split('+')))
    l.sort()
    stdout.write('+'.join(l))
if __name__=='__main__':
    main()
