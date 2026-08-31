first = input()
first = first.split()
n = int(first[0])
s = int(first[1])

sec = input()
sec = sec.split()
for i in range(len(sec)):
    sec[i] = int(sec[i])

sec.sort()
mid  = int(n/2)

if sec[mid]==s:
    print(0)

else:
    count = abs(sec[mid]-s)
    sec[mid] = s
    for i in range(mid+1, n):
        if sec[i]>=s:
            break
        else:
            count+=abs(sec[i]-s)

    j = mid-1
    while j>=0:
        if sec[j]<=s:
            break
        else:
            count+=abs(sec[j]-s)

        j-=1

    print(count)














