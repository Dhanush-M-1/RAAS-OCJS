#include<iostream>
using namespace std;

int main(){
  int k[4][24]={0},a,b;
  string s;
  cin>>a;
  for(int i=0;i<a;i++){
    cin>>s>>b;
    if(s=="S")k[0][b]=1;
    else  if(s=="H")k[1][b]=1;
    else  if(s=="C")k[2][b]=1;
    else  if(s=="D")k[3][b]=1;
  }
  for(int i=0;i<4;i++){
    for(int j=1;j<=13;j++){
      if(k[i][j]==0){
	if(i==0)cout<<"S "<<j<<endl;
	if(i==1)cout<<"H "<<j<<endl;
	if(i==2)cout<<"C "<<j<<endl;
	if(i==3)cout<<"D "<<j<<endl;
	
      }
    }
  }
  return 0;
}

