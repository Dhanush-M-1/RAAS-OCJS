def package_turple(*a_turple):
    print(type(a_turple))
    print(a_turple)
    print(a_turple[-2])

# package_turple(1,4,6)
# package_turple(5,6,7,1,2,3)

def package_dictionary(**a_dictionary):
    print(type(a_dictionary))
    print(a_dictionary)
    print(a_dictionary['a'])


# package_dictionary(a=1,b=9,c=5)
# package_dictionary(x='haha',kk='09',p=6,a='pp')

def unpackage(a,b,c):
    print(a,b,c)

a={"a":1,'b':7,'c':3}
# unpackage(**a)

T=int(input())
for o in range(T):
    x = input()
    x = x.split(sep=' ')
    n = x[0]
    m = x[1]
    a = list()
    b = list()
    aa = input()
    a=aa.split(sep=' ')
    bb = input()
    b=bb.split(sep=' ')
    ok = -1
    for i in a:
        for j in b:
            if i == j:
                ok = i
    if ok == -1:
        print("NO")
    else:
        print("YES")
        print("1 ",end='')
        print(ok)
            
