n = input()
one = list(map(int, input().split(' ')))
two = list(map(int, input().split(' ')))
thr = list(map(int, input().split(' ')))
def foo(arr):
    total = 0
    for e in arr:
        total += e
    return total
onet = foo(one)    
twot = foo(two)    
thrt = foo(thr)    
print(onet-twot)
print(twot-thrt)