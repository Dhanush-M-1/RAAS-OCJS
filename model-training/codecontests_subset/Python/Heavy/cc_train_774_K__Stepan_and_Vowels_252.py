import sys

input = sys.stdin.readline


def gcd(a, b):
    if a == 0:
        return b
    return gcd(b % a, a)


def lcm(a, b):
    return (a * b) / gcd(a, b)

def isprime(n):
    for i in range(2,int(n**0.5)+1):
        if n%i==0:
            return 0
    return 1


def main():
    n = int(input())
    s=input()
    d={}
    d['a']=d['e']=d['i']=d['o']=d['u']=d['y']=0
    i=0
    while(i<n):
        if s[i] in d.keys():
            c=1
            while(i+1<n and s[i]==s[i+1]):
                i+=1
                c+=1
            #print(c)
            if s[i]=='e' or s[i]=='o':
                if c>2:
                    print(s[i],end='')
                else:
                    print(s[i]*c,end='')
            else:
                print(s[i],end='')
        else:
            print(s[i],end='')
        i+=1


if __name__ == "__main__":
    main()
