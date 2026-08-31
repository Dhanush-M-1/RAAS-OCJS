my_list_a = []
my_list_b = []
my_list_c = []

num = int(input())

my_list_a = sorted(map(int,input().split()))
my_list_b = sorted(map(int,input().split()))
my_list_c = sorted(map(int,input().split()))

a = b = 0
for i in range(num):
    if(i<(num-1)):
        if((my_list_a[i]!=my_list_b[i]) and a==0):
            print(my_list_a[i])
            a = 1

if(a==0):
    print(my_list_a[-1])
    
for i in range(num):
    if(i<(num-2)):
        if((my_list_b[i]!=my_list_c[i]) and b==0):
            print(my_list_b[i])
            b = 1
if(b==0):
    print(my_list_b[-1])