s = list(map(int,input().split()))
list_of_lengths = list(map(int,input().split()))
a = []
for j in list_of_lengths:
    if(s[1]%j ==0):
        a.append(int(s[1]//j));
print(min(a))
    
