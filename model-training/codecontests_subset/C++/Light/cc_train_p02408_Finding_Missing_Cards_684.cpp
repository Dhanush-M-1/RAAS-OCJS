#include<iostream>
using namespace std;

int main(void){
  int n,lank;
  bool A[4][14];
  char s;

  for(int i=0;i<4;i++)
    for(int j=1;j<=13;j++)
           A[i][j]=0;

  cin>>n;
  for(int i=0;i<n;i++){
  cin>>s>>lank;
  if(s=='S')A[0][lank]=1;
  if(s=='H')A[1][lank]=1;
  if(s=='C')A[2][lank]=1;
  if(s=='D')A[3][lank]=1;}

  for(int i=0;i<4;i++){
    for(int j=1;j<=13;j++){
      if(A[i][j])continue;
      if(i==0)s='S';
      if(i==1)s='H';
      if(i==2)s='C';
      if(i==3)s='D';
      cout<<s<<" "<<j<<endl;
    }
  }
  
}
