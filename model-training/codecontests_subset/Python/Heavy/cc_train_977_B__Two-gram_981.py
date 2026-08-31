
def find(string, substring): 
    # Initialize count and start to 0 
    count = 0
    start = 0
  
    # Search through the string till 
    # we reach the end of it 
    while start < len(string): 
  
        # Check if a substring is present from 
        # 'start' position till the end 
        flag = string.find(substring, start) 
  
        if flag != -1: 
            # If a substring is present, move 'start' to 
            # the next position from start of the substring 
            start = flag + 1
  
            # Increment the count 
            count += 1
        else: 
            # If no further substring is present 
            # return the value of count 
            return count
n=int(input())
s=input().strip()
x=[]
for i in range(n-1):
    a=s[i]
    for j in range(i+1,n):
        x.append(a+s[j])
count=0
x=list(set(x))

for i in range(len(x)):
    if find(s,x[i])>count:
        count=find(s,x[i])
        r=x[i]
print(r)
        
