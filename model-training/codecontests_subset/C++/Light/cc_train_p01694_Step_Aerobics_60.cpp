#include<iostream>
using namespace std;

int main(){
  while(1){
    string str,str2;
    int N;

    cin>>N;
    if(N==0) break;
    int count=0;
    str2[1]=0;
    for(int i=0;i<N;i++){
      str2[1]=str[1];
      cin>>str;
      if(str[1]==str2[1]) count++;
    }
    cout<<count<<endl;
  }
  return 0;
}