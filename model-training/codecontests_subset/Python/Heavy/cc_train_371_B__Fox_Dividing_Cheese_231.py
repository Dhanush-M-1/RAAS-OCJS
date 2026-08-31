def compute_hcf(x, y):

# choose the smaller number
    if x > y:
        smaller = y
    else:
        smaller = x
    for i in range(1, smaller+1):
        if((x % i == 0) and (y % i == 0)):
            hcf = i 
    return hcf

def hcfnaive(a,b): 
    if(b==0): 
        return a 
    else: 
        return hcfnaive(b,a%b) 

a,b = map(int, input().split())

# hcf = compute_hcf(a, b)
hcf = hcfnaive(a,b)

a = a/hcf
b = b/hcf
count = int(0)
# print(a,b,hcf)
while b>=2:
	# print(b)
	if b%2==0:
		count+=1
		b = b/2
	elif b%3==0:
		count+=1
		b = b/3
	elif b%5==0:
		count+=1
		b = b/5
	else:
		break


while a>=2:
	# print(a)
	if a%2==0:
		count+=1
		a = a/2
	elif a%3==0:
		count+=1
		a = a/3
	elif a%5==0:
		count+=1
		a = a/5
	else:
		break
	# print(a,b)

if(a!=b):
	print(-1)
else:
	print(count)

