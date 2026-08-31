k = int(input())
str = input()

hashmap = {}
countmap = {}

for i in str:
    if i in hashmap:
        hashmap[i] = hashmap[i]+1;
    else:
        hashmap[i] = 1
flag = True;
for i in hashmap.keys():
    if hashmap[i] % k == 0:
        countmap[i] = int(hashmap[i]/k)
    else:
        flag = False;
        break;

if flag == False:
    print("-1")
else:
    answer = ""
    for i in countmap.keys():
        for j in range(0,countmap[i]):
            answer += i
    for i in range(0,k):
        print(answer, end="")

        
    
