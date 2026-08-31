#include<bits/stdc++.h>
using namespace std;

int main(){
  int n,h[40];
  string a;
  while(cin>>n,n){
    for(int i=0;i<n;i++)cin>>a,h[i]=a.size();
    for(int i=0;i<n;i++){
      int now=i,nt=0,nn=0,f=0;
      while(1){
	if(nt==5){
	  f=1;
	  break;
	}
	if(nt==0||nt==2){
	  if(nn>5)break;
	  if(nn==5)nt++,nn=0;
	}else{
	  if(nn>7)break;
	  if(nn==7)nt++,nn=0;
	}
	nn+=h[now];
	now++;
      }
      if(f){
	cout<<i+1<<endl;
	break;
      }
    }
  }
  return 0;
}