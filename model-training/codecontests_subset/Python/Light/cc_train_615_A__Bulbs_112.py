button,bulb=[int(x) for x in input().split()]
light=[]
light=set(light)

for i in range(button):
    on=[int(x) for x in input().split()]
    on.pop(0)
    light=light|set(on)
    
num=len(light)
if num<bulb:
    print('NO')
else:
    print('YES')