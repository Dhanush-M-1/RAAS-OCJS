n=int(input())
a=list(map(int, input().split()))
b=list(map(int, input().split()))
c=list(map(int, input().split()))

a.sort()
b.sort()
c.sort()

def func(a,b):
    i=0
    j=0
    while i<(len(a)):
        while j<(len(b)):
            if a[i]==b[j]:
                i+=1
                j+=1
                
                if j==len(b):
                    return a[i]
            else:
                return a[i]
                
print(func(a,b))
print(func(b,c))