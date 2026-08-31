#include<iostream>
using namespace std;

int main(){
bool cards[4][14];
int n,rank;
char mark;
for(int i=0;i<4;i++){
for(int j=1;j<=13;j++){
cards[i][j]=0;
}
}
cin >>n;
for(int i=0;i<n;i++){
cin >>mark >>rank;
if(mark=='S') cards[0][rank]=1;
if(mark=='H') cards[1][rank]=1;
if(mark=='C') cards[2][rank]=1;
if(mark=='D') cards[3][rank]=1;
}

for(int i=0;i<4;i++){
for(int j=1;j<=13;j++){
if(cards[i][j]) continue;
if(i==0) mark='S';
if(i==1) mark='H';
if(i==2) mark='C';
if(i==3) mark='D';
cout <<mark <<" " <<j <<endl;
}
}
return 0;
}