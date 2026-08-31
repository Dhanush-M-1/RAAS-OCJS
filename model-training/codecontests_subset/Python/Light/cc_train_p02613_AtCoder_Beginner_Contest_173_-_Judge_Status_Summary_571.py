n=int(input())
l=[input()for i in range(n)]
for i in ["AC","WA","TLE","RE"]:
    print(i,"x",l.count(i))