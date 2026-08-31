
t = int(input())
dict = {}
for i in range(t):
    
    numm = str(input()).split(' ')
    nn = str(input()).split(' ')
    mm = str(input()).split(' ')
    dict[i] = nn,mm
stop = 0

for key in dict.keys():
    for j in range(len(dict[key][0])):
        for k in range(len(dict[key][1])):
            if dict[key][0][j] == dict[key][1][k]:
                print("YES")
                print("1", dict[key][0][j])
                stop = 1
                break
        if stop == 1:
            
            break
    if stop == 0:
       print("NO") 
    stop = 0
        
