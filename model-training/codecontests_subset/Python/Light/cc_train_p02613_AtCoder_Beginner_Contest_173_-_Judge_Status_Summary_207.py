dic={"AC":0,"WA":0,"TLE":0,"RE":0}
S=int(input())
for i in range(S):
    B=input()
    dic[B]+=1
for item in dic:
    print(item,"x",dic[item])