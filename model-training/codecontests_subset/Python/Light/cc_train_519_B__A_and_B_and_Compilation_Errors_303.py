n=int(input())
checklist=list(map(str,input().split()))
a=list(map(str,input().split()))
b=list(map(str,input().split()))

if len(set(a))==len(set(checklist)):
    for i in checklist:
        if checklist.count(i)!=a.count(i):
            print(i)
            break
    else:
        pass
else:
    print(''.join(set(checklist)-set(a)))

if len(set(a))==len(set(b)):
    for i in a:
        if b.count(i)!=a.count(i):
            print(i)
            break
    else:
        pass
else:
    print(''.join(set(a)-set(b)))