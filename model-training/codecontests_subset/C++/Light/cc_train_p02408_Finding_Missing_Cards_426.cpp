#include<iostream>
using namespace std;

int main(){
  int n, x;
  int card[4][14]={};
  char m;

  cin>>n;
  for(int i=0;i<n;i++){
    cin>>m>>x;
    if(m=='S') card[0][x]=1;
    if(m=='H') card[1][x]=1;
    if(m=='C') card[2][x]=1;
    if(m=='D') card[3][x]=1;
  }

  for(int i=0;i<4;i++){
    for(int j=1;j<=13;j++){
      if(i==0&&card[i][j]==0) cout<<"S "<<j<<endl;
      if(i==1&&card[i][j]==0) cout<<"H "<<j<<endl;
      if(i==2&&card[i][j]==0) cout<<"C "<<j<<endl;
      if(i==3&&card[i][j]==0) cout<<"D "<<j<<endl;
    }
  }
  
  return 0;
}