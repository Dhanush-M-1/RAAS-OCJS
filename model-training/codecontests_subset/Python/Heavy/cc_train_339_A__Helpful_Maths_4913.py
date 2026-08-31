def bubbleSort(alist):
    for passnum in range(len(alist)-1,0,-1):
        for i in range(passnum):
            if alist[i]>alist[i+1]:
                temp = alist[i]
                alist[i] = alist[i+1]
                alist[i+1] = temp
inp_list=list(input())
inp_list.append('.')
l=len(inp_list)
i=0
out_list=[]
while inp_list[i]!='.' :
    if(inp_list[i]=='+'):
        inp_list.remove('+')
    i+=1
inp_list.remove('.')
bubbleSort(inp_list)
inp_list.insert((len(inp_list)-1),'.')
i=0
while inp_list[i]!='.':
    out_list.append(inp_list[i])
    out_list.append('+')
    i+=1
out_list.append(inp_list[len(inp_list)-1])
print(''.join(out_list))
