#include<iostream>
using namespace std;

int main(){
  int n;
  char ch[201];

  while(cin>>n){
    if(n==0)break;
    int count=0;
    for(int i=0;i<2*n;i++)
      cin>>ch[i];

    for(int i=0;i+3<2*n;i+=4)
      if(ch[i]!=ch[i+2])count++;
    cout<<count<<endl;
  }
  return 0;
}