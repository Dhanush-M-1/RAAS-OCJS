#include<bits/stdc++.h>
using namespace std;
int main(){
  int n;
  while(cin>>n,n){
    int ch=0,a=0;
    for(int i=0;i<n;++i){
      string s; cin>>s;
      if(s=="lu" || s=="ru"){
        if(ch==1) a++, ch=0;
        else ch=1;
      }else if(s=="ld" || s=="rd"){
        if(ch==-1) a++, ch=0;
        else ch=-1;
      }
    }
    cout<<a<<endl;
  }
  return 0;
}