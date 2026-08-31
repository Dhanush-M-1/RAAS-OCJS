#
#
# def do_sort(li,l,r):
#     temp1=sorted(li[l:r+1])
#     count=0
#     for i in range(l,r+1):
#         li[i]=temp1[count]
#         count+=1
#
#
# def are_same(li,temp):
#     for i in range(0,len(li)):
#         if(temp[i]==li[i]):
#             continue
#         else:
#             return False
#     return True
#
#
# def process():
#     m,n=list(map(int,input().split()))
#     li=list(map(int,input().split()))
#     pos=list(map(int,input().split()))
#     pos.sort()
#     pos=[i-1 for i in pos]
#     temp=sorted(li)
#     flag=1
#     l=101
#     r=-1
#     for i in range(0,len(pos)):
#         if(i==0 or pos[i]==pos[i-1]+1):
#             l=min(l,pos[i])
#             r=max(r,pos[i])
#             flag=0
#         elif(pos[i]!=pos[i-1]+1):
#             if(flag==0):
#                 do_sort(li,l,r+1)
#             else:
#                 do_sort(li,pos[i],pos[i]+1)
#             l=pos[i]
#             r=pos[i]
#             flag=1
#     do_sort(li,l,r+1)
#     do_sort(li,pos[-1],pos[-1]+1)
#     if(are_same(li,temp)):
#         print("YES")
#     else:
#         print("NO")
#
# tests=int(input())
# for i in range(0,tests):
#     process()

def process():
    m,n=input().split()
    li=input()
    m=[0]*len(li)
    mistakes=list(map(int,input().split()))
    mistakes=[i-1 for i in mistakes]
    for i in mistakes:
        m[i]+=1
    # print(m)
    s=0
    for i in reversed(range(0,len(m))):
        s+=m[i]
        m[i]=s
    for i in range(0,len(m)):
        m[i]+=1
    # print(m)
    hashi={}
    for i in range(0,len(li)):
        if(li[i] in hashi):
            hashi[li[i]]+=m[i]
        else:
            hashi[li[i]]=m[i]
    # print(hashi)
    for i in range(0,26):
        a=chr(ord('a')+i)
        if(a in hashi):
            print(hashi[a],end=' ')
        else:
            print(0,end=' ')
    print("")







tests=int(input())
for i in range(0,tests):
    process()