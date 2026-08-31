#include<iostream>
using namespace std;
int main(){
  while(1){
    int n,c=0;
    cin>>n;
    if(n==0)break;
    string s,b;
    for(int i=0;i<n;i++){
      cin>>s;
      if(s[1]==b[1])c++;
      b=s;
    }
    cout<<c<<endl;
  }
  return 0;
}