#include<iostream>
#include<cstdio>
using namespace std ;
int main(){
  int n,m,a;
  char c;
  cin>>n;  
  int cards[4][14]={0};
  for(int i=0;i<n;i++){
    cin>>c>>m;
    if(c=='S')a=0;
    if(c=='H')a=1;
    if(c=='C')a=2;
    if(c=='D')a=3;
    cards[a][m]=1;
 }
  char egara[4]={'S','H','C','D'};
  for(int x=0;x<4;x++){
    for(int j=1;j<14;j++){
    if(cards[x][j]==0){
      cout<<egara[x]<<" "<<j<<endl;
    }
    }
  }
 return 0;
}