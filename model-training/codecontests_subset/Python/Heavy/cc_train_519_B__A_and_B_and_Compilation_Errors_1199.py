_ = input()
l1 = input().split()
l2 = input().split()
l3 = input().split()

def freq(l):
    f = {}
    for i in l:
        if i in f.keys():
            f[i] += 1
        else:
            f[i] = 1
    return f

d1 = freq(l1)
d2 = freq(l2)
d3 = freq(l3)

a = [-1,-1]
for key in d1.keys():
    if key not in d2.keys():
        a[0] = key
    elif d2[key] != d1[key]:
        a[0] = key
for key in d2.keys():
    if key not in d3.keys():
        a[1] = key
    elif d2[key] != d3[key]:
        a[1] = key
print(a[0])
print(a[1])

   		   	  		 	 			   									