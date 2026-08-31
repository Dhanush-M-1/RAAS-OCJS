import sys
n = int(input())
trees = [tuple(map(int,input().split()))]
if n == 1:
    print(1)
    sys.exit()
left, right, erect = [1], [0], [0]

x,h = map(int,input().split())
erect.append(max(left[-1],right[-1],erect[-1]))
if x-h > trees[-1][0]+trees[-1][1]:
    left.append(max(erect[-2],left[-1],right[-1])+1)
elif x-h > trees[-1][0]:
    left.append(max(erect[-2],left[-1])+1)
trees.append((x,h))
    
for i in range(2,n):
    x,h = map(int,input().split())
    if trees[-1][0]+trees[-1][1] < x:
        right.append(erect[-1]+1)
    erect.append(max(left[-1],right[-1],erect[-1]))
    if x-h > trees[-1][0]+trees[-1][1]:
        left.append(max(erect[-2],left[-1],right[-1])+1)
    elif x-h > trees[-1][0]:
        left.append(max(erect[-2],left[-1])+1)
    trees.append((x,h))

right.append(erect[-1]+1)
print(right[-1])