c,wc=map(int,input().split())
k=c
w=c
while(w>=wc):
    k=k+w//wc
    w=w//wc+w%wc
print(k)
