'''
delete all the vowels
insert . before each consonant
replace uppercase consonants with lowercase

NOTE:Vowels are letters "A", "O", "Y", "E", "U", "I",
and the rest are consonants

python codeforces.py
'''
'''
vowels=["a", "o", "y", "e", "u", "i"]

string = (input("")).lower()

ans=""
for letter in string:
    if letter not in vowels:
        ans+=("."+letter)

print(ans)
'''
'''
m,n = map(int, input("").split(' '))

if m%2!=0 or n%2!=0:
    print((m*int(n/2))+int(m/2))
else:
    print(m*int(n/2))
'''
'''
if m%2==0:
    print(int(m/2)*n)
elif n%2==0:
    print(int(n/2)*m)
else:
    print((int(m/2)*n)+int(n/2))
'''
'''
n = int(input(""))
x=0
code=[]

for i in range(n):
    code.append(input(""))

for line in code:
    if "++" in line:
        x+=1
    else:
        x-=1

print(x)
'''
'''
string=[]
for i in range(2):
    string.append(input("").lower())

if string[0]<string[1]:
    print(-1)

elif string[0]==string[1]:
    print(0)

else:
    print(1)
'''
'''
positions=input("")

if len(positions)<7:
    print("NO")

else:
    counter=[0,0]
    flag=0
    for i in positions:
        if i=='0':
            if counter[1]!=0:
                counter[1]=0
                counter[0]+=1
            else:
                counter[0]+=1
        elif i=='1':
            if counter[0]!=0:
                counter[0]=0
                counter[1]+=1
            else:
                counter[1]+=1
        #print(counter)

        if (counter[0]>=7 or counter[1]>=7) and flag==0:
            print("YES")
            flag=1

    if flag==0:
        print("NO")
'''

sum_input=input("")
numbers=[]

for i in sum_input:
    if i != '+':
        numbers.append(int(i))

numbers=sorted(numbers)
ans=''
for j in numbers:
    ans=ans+(str(j)+'+')

ans=ans[:-1]

print(ans)






































