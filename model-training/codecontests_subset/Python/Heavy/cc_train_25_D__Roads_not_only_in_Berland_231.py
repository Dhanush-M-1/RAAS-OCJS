# Bosdiwale code chap kr kya milega
# Motherfuckers Don't copy code for the sake of doing it
# ..............
# ╭━┳━╭━╭━╮╮
# ┃┈┈┈┣▅╋▅┫┃
# ┃┈┃┈╰━╰━━━━━━╮
# ╰┳╯┈┈┈┈┈┈┈┈┈◢▉◣
# ╲┃┈┈┈┈┈┈┈┈┈┈▉▉▉
# ╲┃┈┈┈┈┈┈┈┈┈┈◥▉◤
# ╲┃┈┈┈┈╭━┳━━━━╯
# ╲┣━━━━━━┫
# ……….
# .……. /´¯/)………….(\¯`\
# …………/….//……….. …\\….\
# ………/….//……………....\\….\
# …./´¯/…./´¯\……/¯ `\…..\¯`\
# ././…/…/…./|_…|.\….\….\…\.\
# (.(….(….(…./.)..)...(.\.).).)
# .\…………….\/../…....\….\/…………/
# ..\…………….. /……...\………………../
# …..\…………… (………....)……………./

n = int(input())
parent = [i for i in range(n)]

def find_set(v):
    if v!=parent[v]:
        parent[v] = find_set(parent[v])
    return parent[v]

rem = []
for _ in range(n-1):
    u,v = list(map(int,input().split()))
    l = [u,v]
    l.sort()
    u,v = l
    u-=1
    v-=1
    a = find_set(u)
    b = find_set(v)
    if a!=b:
        if a>b:
            a,b = b,a
        for i in range(len(parent)):
            if parent[i]==b:
                parent[i] = a
    else:
        rem.append([u+1,v+1])
d = {}
for i in range(len(parent)):
    d[parent[i]] = i
ind = []
for i in d:
    ind.append(d[i]+1)
ans = []
for i in range(1,len(ind)):
    ans.append([ind[i],ind[i-1]])
print(len(rem))
for i in range(len(rem)):
    print(*rem[i],*ans[i])