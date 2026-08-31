mas1 = input().split(" ")
mas2 = input().split(" ")

n = int(mas1[0])
k = int(mas1[1])

max_vedro = 0
for i in mas2:
	swap_vedro = int(i)
	if k%swap_vedro==0 and swap_vedro>max_vedro:
		max_vedro =  swap_vedro

print(k//max_vedro)
