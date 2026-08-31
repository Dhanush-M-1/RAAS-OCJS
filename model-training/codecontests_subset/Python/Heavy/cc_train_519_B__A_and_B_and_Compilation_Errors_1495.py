n = int(input())

a = list( map(int, input().split(' ')) )
b = list( map(int, input().split(' ')) )
c = list( map(int, input().split(' ')) )

counter_a = {}
counter_b = {}
counter_c = {}

for i in a:
    try:
        counter_a[i] = counter_a[i] + 1
    except:
        counter_a[i] = 1

for i in b:
    try:
        counter_b[i] = counter_b[i] + 1
    except:
        counter_b[i] = 1

for i in c:
    try:
        counter_c[i] = counter_c[i] + 1
    except:
        counter_c[i] = 1

removed1 = -1
removed2 = -1

for i in counter_a.keys():
    # print("estou aqui com i = ", i)
    try:
        if(counter_a[i] != counter_b[i]):
            removed1 = i
            # print("estou aqui 2")
    except:
        removed1 = i
        # print("estou aqui 3")

for i in counter_b.keys():
    try:
        if(counter_b[i] != counter_c[i]):
            removed2 = i
    except:
        removed2 = i


print(removed1)
print(removed2)
			  	  	    	     				  		 	 	