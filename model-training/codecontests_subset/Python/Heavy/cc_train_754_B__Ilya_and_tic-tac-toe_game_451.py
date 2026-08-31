l=[]
for i in range(4):
    l.append(list(input()))
score="NO"
'''def checkpair(i,j):
    # if(j<2):
    #     if (l[i][j+1]=="x" and l[i][j+2]==".") or (l[i][j+2]=="x" and l[i][j+1]=="."):
    #         print("YES")
    #         return
    # if(j>2):
    #     if (l[i][j+1]=="x" and l[i][j+2]==".") or (l[i][j+2]=="x" and l[i][j+1]=="."):
    #         print("YES")
    #         return
    # if (i<2):
    #     if (l[i+1][j]=="x" and l[i+2][j]==".") or (l[i+2][j]=="x" and l[i+1][j]=="."):
    #         print("YES")
    #         return
    
for i in range(4):
    for j in range(4):
'''
# l=[]
# for i in range(4):
#     l.append(input())
# test=True
# for i in range(4):
#     if("xOx" in l[i]):
#         print("YES")
#         test=False
#         break
# if (test):
#     # for i in range(4):
#     #     m=[]
#     #     m.append(list(l[i]))
#     #     m=zip(*m)
#     #     temp=[]
#     if (i<2):
#         if (l[i+1][j]=="x" and l[i+2][j]==".") or (l[i+2][j]=="x" and l[i+1][j]=="."):
#             print("YES")
#             test=False

m=[]
m.append(["o"]*8)
m.append(["o"]*8)
for i in range(4):
    m.append(["o"]*2 + l[i] + ["o"]*2)
m.append(["o"]*8)
m.append(["o"]*8)
def check(i,j):
    i+=2
    j+=2
    if (m[i][j+1]=="x" and m[i][j+2]==".") or (m[i][j+2]=="x" and m[i][j+1]=="."):
        # score="YES"
        return "YES"
    if (m[i][j-1]=="x" and m[i][j-2]==".") or (m[i][j-2]=="x" and m[i][j-1]=="."):
        # score="YES"
        return "YES"
    if (m[i+1][j]=="x" and m[i+2][j]==".") or (m[i+2][j]=="x" and m[i+1][j]=="."):
        # score="YES"
        return "YES"
    if (m[i-1][j]=="x" and m[i-2][j]==".") or (m[i-2][j]=="x" and m[i-1][j]=="."):
        # score="YES"
        return "YES"
    if (m[i+1][j+1]=="x" and m[i+2][j+2]==".") or (m[i+2][j+2]=="x" and m[i+1][j+1]=="."):
        # score="YES"
        return "YES"
    if (m[i-1][j-1]=="x" and m[i-2][j-2]==".") or (m[i-2][j-2]=="x" and m[i-1][j-1]=="."):
        # score="YES"
        return "YES"
    if (m[i-1][j+1]=="x" and m[i-2][j+2]==".") or (m[i-2][j+2]=="x" and m[i-1][j+1]=="."):
        # score="YES"
        return "YES"
    if (m[i+1][j-1]=="x" and m[i+2][j-2]==".") or (m[i+2][j-2]=="x" and m[i+1][j-1]=="."):
        # score="YES"
        return "YES"
    return "NO"
for i in range(4):
    for j in range(4):
        if (l[i][j]=="x"):
            score=check(i,j)
            if (score=="YES"):
                break
    if (score=="YES"):
                break
print(score)