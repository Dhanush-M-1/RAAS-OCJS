inp=input()
inp=inp.split(' ')
inp1=input()
inp1=inp1.split(' ')

i=0
data=[]
while i<len(inp1):
    if int(inp[1])%int(inp1[i])==0:
        data.append(int(inp1[i]))
    i=i+1
j=int(max(data))
print(int(int(inp[1])/j))
