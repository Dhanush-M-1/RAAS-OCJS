
################################################
################################################
######### Written By Boddapati Mahesh ##########
######### IIIT Hyderabad #######################
################################################
################################################


def fast_exp(b, e, m):
    r = 1
    if 1 & e:
        r = b
    while e:
        e >>= 1
        b = (b * b) % m
        if e & 1: r = (r * b) % m
    return r

def factorial(n,m):
    f = 1
    for i in range(1, n + 1): 
        f = (f * i) % m
    return f 

m = 1000000007
e = int(input())
if e == 0:
	print(0)
else:
	b = 2
	r = fast_exp(b, e-1, m)
	fm = factorial(e,m)
	print((fm-r)%m)
