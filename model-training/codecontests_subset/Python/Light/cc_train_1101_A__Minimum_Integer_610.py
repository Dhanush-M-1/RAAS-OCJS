count = int(input())
mas = []
for i in range(count):
    s = input().split(' ')
    l = int(s[0])
    r = int(s[1])
    d = int(s[2])
    if d<l:
        #print('#1')
        mas.append(d)
    else:
        #print('#2')
        j = r/d
        if j%1 == 0:
          #  print('#3',j,r,d)
            j = (j+1)*d
        else:
         #   print('#4',j)
            j = (j - (j%1) + 1)*d
        mas.append(j)
    print(int(mas[-1]))
