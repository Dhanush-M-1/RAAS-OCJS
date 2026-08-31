#include<iostream>
#include<string>
using namespace std;

int main(){

  int n;
  while(cin>>n){

    if(n==0){
      break;
    }
  string f[n];
  for(int i=0;i<n;i++){
    cin>>f[i];
  }

  int t=0;

  for(int i=1;i<n;i++){

    if(f[i]=="lu"&&f[i-1]=="ru"){
	t++;
    }else if(f[i]=="ru"&&f[i-1]=="lu"){
      t++;
    }else if(f[i]=="ld"&&f[i-1]=="rd"){
      t++;
    }else if(f[i]=="rd"&&f[i-1]=="ld"){
      t++;
    }

  }
  

  cout<<t<<endl;

  }

  return 0;



}