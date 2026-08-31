n = int(input())
a = list(map(int, input().split()))
def lcm(a,b):
    while a != 0 and b != 0:
        if a > b:
            a %= b
        else:
            b %= a
    return (a+b)
'''
t = 1
for i in range(1,n):
    if a[i] > 0:
        if a[i] % t and t % a[i]:
            t = lcm(t,a[i])
        else:
            if t < a[i]:
                t = a[i]
print(t)'''
#diffs = []
x = max(a)
z = 0
s_diff = 0
for i in range(n):
    diff =x-a[i]
    z = lcm(z,diff)
    #print(nod)
    s_diff += diff
print(s_diff//z,z)
#print(max_diff)
        
    
