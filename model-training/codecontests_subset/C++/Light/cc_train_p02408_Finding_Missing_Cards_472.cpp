#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,num,a[4][13];
  char mar;
  memset(a,0,sizeof(a));
  cin>>n;
  for(int i=0;i<n;i++){
    cin>>mar>>num;
    if(mar=='S') a[0][num-1]=1;
    if(mar=='H') a[1][num-1]=1;
    if(mar=='C') a[2][num-1]=1;
    if(mar=='D') a[3][num-1]=1;
  }

  for(int i=0;i<4;i++){
    for(int j=0;j<13;j++){
      if(a[i][j]==0){
	if(i==0) cout<<'S'<<' '<<j+1<<endl;
	if(i==1) cout<<'H'<<' '<<j+1<<endl;
	if(i==2) cout<<'C'<<' '<<j+1<<endl;
	if(i==3) cout<<'D'<<' '<<j+1<<endl;
      }
    }
  }
  return(0);
}

