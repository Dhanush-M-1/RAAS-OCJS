#a = input()
#b = input()
a, b = input().split()

a = int(a)
b = int(b)

def new(x):
    if(x<b):
        return 0
    else:
        count = int(x/b) + new(int(x/b) + x%b)
        return count

count = a + new(a)
print(int(count))