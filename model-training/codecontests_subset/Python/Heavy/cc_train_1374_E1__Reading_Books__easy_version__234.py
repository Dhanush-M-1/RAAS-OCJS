import sys;
import math;
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def get_string(): return sys.stdin.readline().strip()

#def helper(n):
    

    


n,k = get_ints();
alice = [];
bob = [];
comm = [];
for i in range(n):
    t,a,b = get_ints();
    if(a==1 and b==1):
        comm.append(t);
        continue;
    if(a==1):
        alice.append(t);
    if(b==1):
        bob.append(t);
alice.sort();bob.sort(),comm.sort();
#print(alice)
#print(bob)
#print(comm)
ans = 0;
ptr1 = 0;
ptr2 = 0;
fans = []
while(ptr1<min(len(alice),len(bob)) and ptr2<len(comm)):
    if(alice[ptr1]+bob[ptr1]<comm[ptr2]):
        fans.append(alice[ptr1]+bob[ptr1]);
        ptr1+=1;
    else:
        fans.append(comm[ptr2]);
        ptr2+=1;
#print(fans);
while(ptr1<min(len(alice),len(bob))):
    fans.append(alice[ptr1]+bob[ptr1]);
    ptr1+=1;
while(ptr2<len(comm)):
    fans.append(comm[ptr2]);
    ptr2+=1;
if(len(fans)<k):
    print(-1);
else:
    print(sum(fans[0:k]));
