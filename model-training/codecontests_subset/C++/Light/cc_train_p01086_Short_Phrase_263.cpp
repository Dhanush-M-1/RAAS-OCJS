#include<iostream>
using namespace std;

int main(){

  int n, w[5]={5, 7, 5, 7, 7};
  string s[40];

  while(cin>>n, n){
    for(int i=0;i<n;i++) cin>>s[i];

    for(int i=0;i<n;i++){
      int id=0, sw=0;
      bool f=false;
      for(int j=i;j<n;j++){
        sw+=s[j].size();
        if(sw==w[id]){
          id++;
          sw=0;
        }else if(sw>w[id]) break;
        if(id==5){
          cout<<i+1<<endl;
          f=true;
          break;
        }
      }
      if(f) break;
    }
  }

  return 0;
}